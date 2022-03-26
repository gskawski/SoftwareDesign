using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.ServiceModel.Web;
using System.Text;

namespace RESTWebService
{
    [ServiceContract]
    public interface IRESTService
    {
        [OperationContract]
        [WebInvoke(Method = "GET", ResponseFormat = WebMessageFormat.Json, UriTemplate = "/GetIDPassword?first={firstName}&last={lastName}&age={age}")]
        results GetIDPassword(string firstName, string lastName, int age);
    }

    [DataContract]
    public class results
    {
        [DataMember]
        public int loginID { get; set; }
        [DataMember]
        public string password { get; set; }
    }
}
