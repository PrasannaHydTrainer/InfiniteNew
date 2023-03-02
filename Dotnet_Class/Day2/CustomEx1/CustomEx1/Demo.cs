using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CustomEx1
{
    internal class Demo
    {
        public void Check(int age)
        {
            if (age < 18)
            {
                throw new VotingException("You are not Elligible for Voting...");
            }
            Console.WriteLine("You Can Vote...");
        }
        static void Main(string[] args)
        {
            int age;
            Console.WriteLine("Enter Your Age   ");
            age = Convert.ToInt32(Console.ReadLine());
            Demo obj = new Demo();
            try
            {
                obj.Check(age);
            }
            catch(VotingException e)
            {
                Console.WriteLine(e.Message);
            }
            catch (Exception e)
            {
                Console.WriteLine(e);
            }
        }
    }
}
