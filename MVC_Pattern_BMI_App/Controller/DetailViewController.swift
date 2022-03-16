//
//  DetailViewController.swift
//  BMICalculator
//
//  Created by Glenn Skawski on 11/14/20.
//

import UIKit

class DetailViewController: UIViewController {
    
    var educateMeLink: String?
    
    var bmiManager = BMIManager()

    override func viewDidLoad() {
        super.viewDidLoad()
        
        bmiManager.delegate = self
        
        if educateMeLink != nil {
            let url = URL(string: educateMeLink!)
            UIApplication.shared.openURL(url!)
        } else {
            bmiManager.fetchBMI(height: "60", weight: "156")
            DispatchQueue.main.asyncAfter(deadline: .now() + 2) {
                let url = URL(string: self.educateMeLink!)
                UIApplication.shared.openURL(url!)
            }
        }
    }
}

extension DetailViewController: BMIManagerDelegate {
    
    func didUpdateBMI(_ bmiManager: BMIManager, bmiData: BmiModel) {
        DispatchQueue.main.async {
            self.educateMeLink = bmiData.moreResult[0]
        }
    }
    
    func didFailWithError(error: Error) {
        print(error)
    }
}
