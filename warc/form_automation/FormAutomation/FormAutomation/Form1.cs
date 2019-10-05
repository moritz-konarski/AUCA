using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace FormAutomation
{
    public partial class Form1 : Form
    {

        WarcInterface warcInterface;

        public Form1()
        {
            InitializeComponent();
        }

        private void LoginButton_Click(object sender, EventArgs e)
        {
            String password = PasswordBox.Text;
            String login = LoginBox.Text; 
            warcInterface = new WarcInterface(login, password);


        }
    }
}
