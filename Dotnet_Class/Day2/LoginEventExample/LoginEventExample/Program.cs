using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LoginEventExample
{
    internal class Program
    {
        public delegate void LoginAuthentication();
        public static event LoginAuthentication LoginSuccess;
        public static event LoginAuthentication LoginFailure;

        static Dictionary<string, string> userData;
        static Program()
        {
            userData = new Dictionary<string, string>();
            userData.Add("Ayush", "Gupta");
            userData.Add("Ashish", "Kalra");
            userData.Add("Harsh", "Singh");
            userData.Add("Mahesh", "Vishnoi");
            userData.Add("Vivek", "Johari");
        }

        public static void Success()
        {
            Console.WriteLine("Your Credentials are correct...Nice");
        }

        public static void Failure()
        {
            Console.WriteLine("Invalid Credentials...");
        }
        public static void ValidateMe(string user, string pwd)
        {
            string result;
            userData.TryGetValue(user, out result);
            if (result.Equals(pwd))
            {
                LoginSuccess = new LoginAuthentication(Success);
                LoginSuccess.Invoke();
            }
            else
            {
                LoginFailure = new LoginAuthentication(Failure);
                LoginFailure.Invoke();
            }
        }
        static void Main(string[] args)
        {
            string user, pwd;
            Console.WriteLine("Enter UserName   ");
            user = Console.ReadLine();
            Console.WriteLine("Enter Password   ");
            pwd = Console.ReadLine();
            ValidateMe(user, pwd);
        }
    }
}
