//
//  BmiModel.swift
//  BMICalculator
//
//  Created by Glenn Skawski on 11/8/20.
//

import UIKit

struct BmiModel {
    let bmiResult: Float
    let moreResult: [String]
    let messageResult: String
    
    var color: UIColor {
        if bmiResult < 18 {
            return #colorLiteral(red: 0.2588235438, green: 0.7568627596, blue: 0.9686274529, alpha: 1)
        } else if bmiResult < 25 {
            return #colorLiteral(red: 0.4666666687, green: 0.7647058964, blue: 0.2666666806, alpha: 1)
        } else if bmiResult < 30 {
            return #colorLiteral(red: 0.5568627715, green: 0.3529411852, blue: 0.9686274529, alpha: 1)
        } else {
            return #colorLiteral(red: 0.9254902005, green: 0.2352941185, blue: 0.1019607857, alpha: 1)
        }
    }
}
