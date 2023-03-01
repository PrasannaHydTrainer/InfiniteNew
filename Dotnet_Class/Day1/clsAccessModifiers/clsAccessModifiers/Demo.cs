using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace clsAccessModifiers
{
    public class Demo
    {
        private string topic = "Dotnet Training";
        public string trainer = "Prasanna Pappu";
        internal string venue = "Pune";
        protected string mode = "offline/online";
        protected internal string state = "Maha Rastra";

        public void Show()
        {
            Console.WriteLine("Topic is " +topic);
            Console.WriteLine("Trainer is  " +trainer);
            Console.WriteLine("Venue  " +venue);
            Console.WriteLine("Mode  " +mode);
            Console.WriteLine("State   " +state);
        }
    }
}
