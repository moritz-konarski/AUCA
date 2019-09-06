using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using System.Threading;
using ZedGraph;
namespace Lagranj
{
    public partial class Form1 : Form
    {
        double E;
         double [] x;
         double N,h;
        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            groupBox1.Visible = false;
        }
        public double func(double x)
        {
            E = Convert.ToDouble(comboBox2.Text);
            //prob 1
            if (comboBox3.SelectedIndex == 0)                           // здесь задаются тестовые функции
                return ((1 - Math.Exp(-x / E)) / (1 - Math.Exp(-1 / E)));
            //prob 2
            else if (comboBox3.SelectedIndex == 1)
                return ((Math.Exp(-(1 - x) / E) - Math.Exp((1) / E))) / (1 - (Math.Exp(-1 / E)));
            //prob 3
            else if (comboBox3.SelectedIndex == 2)
                return (1 - (Math.Exp(-x / Math.Sqrt(E)) + Math.Exp((x - 1) / Math.Sqrt(E))) / (1 - (Math.Exp(-x / Math.Sqrt(E)))));
            //prob 4
            else if (comboBox3.SelectedIndex == 3)
                return (Math.Log(1 + x / E) / Math.Log(1 + 1 / E));
            //prob 5
            else if (comboBox3.SelectedIndex == 4)
                return Math.Cos((Math.PI * x) / E);
            //prob 6
            else if (comboBox3.SelectedIndex == 5)
                return x * Math.Cos((Math.PI * x) / E);
            //prob 7
            else if (comboBox3.SelectedIndex == 6)
                return E / (E + Math.Pow(2 * x + 1, 2));
            //prob 8
            else if (comboBox3.SelectedIndex == 7)
            {
                if (x == 0)
                    return 0;
                else
                    return Math.Exp(-(1 - x) / (E - x));
            }
            //prob 9
            else if (comboBox3.SelectedIndex == 8)
            {
                if (x == 0)
                    return 0;
                else
                    return x *  Math.Log(1 / x);
            }
            //prob 10
            else if (comboBox3.SelectedIndex == 9)
                return E / (E + Math.Pow(2 * x + 1, 2));
            //prob 14
            else if (comboBox3.SelectedIndex == 10)
                return Math.Cos((Math.PI * x) / E);
            else return 0;

        }
        public double lagrange(double X)                                 //  здесь задается многочлен Лагранжа
        {

            N = Convert.ToDouble(comboBox1.Text);
            x = new double[Convert.ToInt32(N + 1)];
            h = 1.0 / (N - 1.0);

            if (comboBox4.SelectedIndex == 0)
                for (int i = 1; i <= N; i++)
                {
                    x[i] = (i - 1) * h;
                }
            if (comboBox4.SelectedIndex == 1)
                for (int i = 1; i <= N; i++)
                {
                    x[i] = (1.0 / 2.0) * (1 - Math.Cos(((2 * i - 1) * Math.PI) / (2.0 * N)));
                }


            double result = 0.0;
            for (int j = 1; j<=Convert.ToInt32(N); j++)
            {
               
                result =0.0;
            }
            return result;


        }

        
        public void Draw()
        {

            PointPairList list1 = new PointPairList();
            GraphPane myPane = ctrl.GraphPane;
            myPane.CurveList.Clear();
            for (double x = 0.0; x <= 1.0; x += 0.0001)
            {
                list1.Add(x, func(x));
            }
            LineItem line1 = myPane.AddCurve("Тестовая функция", list1, Color.Black, SymbolType.None);
            line1.Line.IsVisible = true;
            line1.Symbol.Fill.Color = Color.Black;
            line1.Symbol.Fill.Type = FillType.Solid;
            line1.Symbol.Size = 2.0f;
            ctrl.AxisChange();
            ctrl.Invalidate();
            myPane.Title.Text = " ";
            PointPairList list2 = new PointPairList();
            for (double X = 0.0; X <= 1.0; X += 0.001)
            {
                list2.Add(X, lagrange(X));
            }
            

            LineItem line2 = myPane.AddCurve("Интерполянт", list2, Color.Red, SymbolType.None);
            line2.Line.IsVisible = true;
            line2.Symbol.Fill.Color = Color.Red;
            line2.Symbol.Fill.Type = FillType.Solid;
            line2.Symbol.Size = 6.0f;
            ctrl.AxisChange();
            ctrl.Invalidate();
        }

        private void label1_Click(object sender, EventArgs e)
        {
            
        }

        private void button1_Click(object sender, EventArgs e)
        {
            groupBox1.Visible = true;
            for (int i = 0; i < 10; i++)
            {
                Thread.Sleep(60);
                this.Opacity = this.Opacity - 0.1;
            }
            for (int i = 0; i < 10; i++)
            {
                Thread.Sleep(60);
                this.Opacity = this.Opacity + 0.1;
            }
           
            
        }

        private void button2_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }

        private void button3_Click(object sender, EventArgs e)
        {
            Draw();
        }

        private void comboBox2_SelectedIndexChanged(object sender, EventArgs e)
        {

        }

        private void ctrl_Load(object sender, EventArgs e)
        {

        }

        private void label4_Click(object sender, EventArgs e)
        {

        }
        
       
        
    }
}
