using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Net;
using System.IO;
using System.Runtime.Serialization.Json;
using Newtonsoft.Json;

namespace PWLoginServiceApplication
{
    public partial class Default : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
        }

        SOAPServiceReference.SOAPServiceClient soapProxy = new SOAPServiceReference.SOAPServiceClient();
        protected void Button1_Click(object sender, EventArgs e)
        {
            string firstName = TextBox4.Text;
            string lastName = TextBox5.Text;
            int age = Int32.Parse(TextBox6.Text);

            SOAPServiceReference.results res = soapProxy.GetIDPassword(firstName, lastName, age);

            TextBox7.Text = res.loginID.ToString();
            TextBox8.Text = res.password;
        }

        protected void Button2_Click(object sender, EventArgs e)
        {
            string firstName = TextBox4.Text;
            string lastName = TextBox5.Text;
            int age = Int32.Parse(TextBox6.Text);
            string url = $@"http://localhost:60024/RESTService.svc/GetIDPassword?first={firstName}&last={lastName}&age={age}";

            HttpWebRequest request = (HttpWebRequest)WebRequest.Create(url);
            WebResponse response = request.GetResponse();
            Stream responseStream = response.GetResponseStream();

            StreamReader reader = new StreamReader(responseStream);
            String json = reader.ReadToEnd();
            results r = JsonConvert.DeserializeObject<results>(json);
            TextBox9.Text = r.loginID.ToString();
            TextBox10.Text = r.password;
        }

        [Serializable]
        public class results
        {
            public int loginID { get; set; }
            public string password { get; set; }
        }

    }
}