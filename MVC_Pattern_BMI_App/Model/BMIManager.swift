//
//  BMIManager.swift
//  BMICalculator
//
//  Created by Glenn Skawski on 11/14/20.
//

import Foundation

protocol BMIManagerDelegate {
    func didUpdateBMI(_ bmiManager: BMIManager, bmiData: BmiModel)
    func didFailWithError(error: Error)
}

struct BMIManager {
    let bmiURL = "http://webstrar99.fulton.asu.edu/page3/Service1.svc/calculateBMI?"
    
    var delegate: BMIManagerDelegate?
    
    func fetchBMI(height: String, weight: String) {
        let urlAsString = "\(bmiURL)height=\(height)&weight=\(weight)"
        performRequest(with: urlAsString)
    }

    func performRequest(with urlAsString: String) {
        if let url = URL(string: urlAsString) {
            let urlSession = URLSession(configuration: .default)
            let jsonQuery = urlSession.dataTask(with: url) { (data, response, error) in
                if (error != nil) {
                    self.delegate?.didFailWithError(error: error!)
                    return
                }
                if let safeData = data {
                    if let bmi = self.parseJSON(safeData) {
                        self.delegate?.didUpdateBMI(self, bmiData: bmi)
                    }
                }
            }
            jsonQuery.resume()
        }
    }

    func parseJSON(_ bmi: Data) -> BmiModel? {
        let decoder = JSONDecoder()
        do {
            let jsonResult = try decoder.decode(BMI.self, from: bmi)
            let bmi = jsonResult.bmi
            let more = jsonResult.more
            let risk = jsonResult.risk
            
            let bmiData = BmiModel(bmiResult: bmi, moreResult: more, messageResult: risk)
            return bmiData
            
        } catch {
            delegate?.didFailWithError(error: error)
            return nil
        }
    }
}
