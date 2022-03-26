using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.ServiceModel.Web;
using System.Text;

namespace RESTWebService
{
    public class RESTService : IRESTService
    {
        public results GetIDPassword(string firstName, string lastName, int age)
        {
            results res = new results();

            Random rand = new Random();
            int randNum = rand.Next(100, 201);
            int id = age * randNum;

            string pwLastName = lastName.Substring(0, 2).ToLower();
            string pwFirstName = firstName.Substring(firstName.Length - 2).ToLower();
            string pwAge = (age % 5).ToString();
            string pw = pwLastName + pwFirstName + pwAge;

            res.loginID = id;
            res.password = pw;

            return res;
        }
    }
}
