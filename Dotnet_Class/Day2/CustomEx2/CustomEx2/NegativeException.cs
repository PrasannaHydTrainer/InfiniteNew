using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CustomEx2
{
    public class NegativeException : ApplicationException
    {
        public NegativeException(string error) : base(error)
        {

        }
    }
}
