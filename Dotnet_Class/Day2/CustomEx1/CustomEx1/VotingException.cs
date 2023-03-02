using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CustomEx1
{
    public class VotingException : ApplicationException
    {
        public VotingException(string error) : base(error)
        {

        }
    }
}
