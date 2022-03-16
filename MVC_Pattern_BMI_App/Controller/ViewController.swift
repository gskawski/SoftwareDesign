//
//  ViewController.swift
//  BMICalculator
//
//  Created by Glenn Skawski on 11/7/20.
//

import UIKit

class ViewController: UIViewController {
    

    @IBOutlet weak var heightInput: UITextField!
    @IBOutlet weak var weightInput: UITextField!
    
    @IBOutlet weak var callBmiApp: UIButton!
    @IBOutlet weak var educateMe: UIButton!
    @IBOutlet weak var bmiResult: UITextView!
    @IBOutlet weak var bmiMessage: UITextView!
    @IBOutlet weak var bmiColor: UILabel!
    
    var bmiManager = BMIManager()
    
    var educateMeLink: String?
    var callBmiApiHasBeenPressed = false
    
    override func viewDidLoad() {
        super.viewDidLoad()
        heightInput.delegate = self
        weightInput.delegate = self
        bmiManager.delegate = self
    }
}
    
//MARK: - UITextFieldDelegate
    
extension ViewController: UITextFieldDelegate {
    
    @IBAction func callBmiApiPressed(_ sender: UIButton) {
        heightInput.endEditing(true)
        weightInput.endEditing(true)
        callBmiApiHasBeenPressed = true
        if textFieldShouldEndEditing(heightInput) == false || textFieldShouldEndEditing(weightInput) == false {
            bmiManager.fetchBMI(height: "60", weight: "156")
        }
    }

    @IBAction func educateMePressed(_ sender: UIButton) {
        heightInput.endEditing(true)
        weightInput.endEditing(true)
        self.performSegue(withIdentifier: "detailView", sender: self)
    }
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        if(segue.identifier == "detailView"){
            if let viewController: DetailViewController = segue.destination as? DetailViewController {
                viewController.educateMeLink = self.educateMeLink;
            }
        }
    }
    
    func textFieldShouldReturn(_ textField: UITextField) -> Bool {
        heightInput.endEditing(true)
        weightInput.endEditing(true)
        return true
    }

    func textFieldShouldEndEditing(_ textField: UITextField) -> Bool {
        if textField.text != "" {
            return true
        } else {
            textField.placeholder = "Type Something"
            return false
        }
    }
    
    func textFieldDidEndEditing(_ textField: UITextField) {
        if let height = heightInput.text, let weight = weightInput.text {
            bmiManager.fetchBMI(height: height, weight: weight)
        }
    }
}
    
//MARK: - WeatherManagerDelegate

extension ViewController: BMIManagerDelegate {
    
    func didUpdateBMI(_ bmiManager: BMIManager, bmiData: BmiModel) {
        DispatchQueue.main.async {
            self.bmiResult.text = String(bmiData.bmiResult)
            self.bmiMessage.text = bmiData.messageResult
            self.educateMeLink = bmiData.moreResult[0]
            self.bmiColor.backgroundColor = bmiData.color
        }
    }
    
    func didFailWithError(error: Error) {
        print(error)
    }
}
    
    
    

