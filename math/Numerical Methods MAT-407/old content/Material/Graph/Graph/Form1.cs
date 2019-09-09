using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.Windows.Forms;
using ZedGraph;// подключаем ZedGraph
namespace Graph
{
    public partial class FrmLabs1 : Form
    {
        public static int CountPoints;
        public static double E;
            
        public FrmLabs1()
        {
            InitializeComponent();
        }
        public double function1(double x,double E)
        { 
         return (1 - Math.Exp(-x / E)) / (1 - Math.Exp(-1 / E)); 
            //возвращает значение данной функции в заданной точке x        
           // return (Math.Exp(-x / E));
        }
        public double function2(double x, double E)
        {
            return Math.Sin(x) + E;
        }
        private void btnDraw_Click(object sender, EventArgs e)
        {

            Draw();
        }
        public void Draw()
        {            
          
          
            if (cmbNodes.SelectedItem != null)
                CountPoints =Convert.ToInt32(cmbNodes.Text);
            if (cmbEpsylon.SelectedItem != null)
              E = Convert.ToDouble(cmbEpsylon.Text);
             
            // создаем объект список, содержащий точки - координаты графика
          // в программе одновременно рисуются два графика 
            PointPairList list1 = new PointPairList();
            PointPairList list2 = new PointPairList();
            int xmin = 0;
            int xmax = 1;
            double h;
            
            h = 1.0 / CountPoints;
          
            for (double i = xmin; i < xmax; i+=h)
            {// задаем сеточную функцию
            
                list1.Add(i, function1(i, E));
                             
            }
            for (double i = xmin; i < xmax; i += h)
            {// задаем сеточную функцию

                list2.Add(i, function2(i, E));

            }
            //Создаем графический объект- панель для отображения графика
            GraphPane myPane = ctrl.GraphPane;
            myPane.CurveList.Clear();
            // Отображаем сетку
            myPane.XAxis.MajorGrid.IsVisible = true;
            myPane.YAxis.MajorGrid.IsVisible = true;
            // подписи осей можно менять
            myPane.XAxis.Title.Text = "My X Axis";
            myPane.YAxis.Title.Text = "My Y Axis";
            //подписи графиков
            myPane.Title.Text = "My Test Graph";
            //Создается кривая и задается текст легенды
            LineItem myLine1=myPane.AddCurve("Function#1",list1,Color.Blue,SymbolType.Square);
            LineItem myLine2 = myPane.AddCurve("Function#2", list2, Color.Red, SymbolType.Circle);

            // Обновляются данные об осях, 
            ctrl.AxisChange();
            // Толщина линии
            myLine1.Line.Width = 2.0f;
            myLine2.Line.Width = 2.0f;
            // Обновляются данные
            ctrl.Invalidate();

        }
        private void FrmLabs1_Load(object sender, EventArgs e)
        { 

        }

        private void btnExit_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }
    }
}