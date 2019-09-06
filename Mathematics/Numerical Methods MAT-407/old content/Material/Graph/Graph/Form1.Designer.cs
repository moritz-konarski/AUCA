namespace Graph
{
    partial class FrmLabs1
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.components = new System.ComponentModel.Container();
            this.ctrl = new ZedGraph.ZedGraphControl();
            this.btnDraw = new System.Windows.Forms.Button();
            this.label1 = new System.Windows.Forms.Label();
            this.cmbNodes = new System.Windows.Forms.ComboBox();
            this.label2 = new System.Windows.Forms.Label();
            this.cmbEpsylon = new System.Windows.Forms.ComboBox();
            this.btnExit = new System.Windows.Forms.Button();
            this.label3 = new System.Windows.Forms.Label();
            this.cmbTask = new System.Windows.Forms.ComboBox();
            this.SuspendLayout();
            // 
            // ctrl
            // 
            this.ctrl.Location = new System.Drawing.Point(27, 20);
            this.ctrl.Margin = new System.Windows.Forms.Padding(5, 5, 5, 5);
            this.ctrl.Name = "ctrl";
            this.ctrl.ScrollGrace = 0;
            this.ctrl.ScrollMaxX = 0;
            this.ctrl.ScrollMaxY = 0;
            this.ctrl.ScrollMaxY2 = 0;
            this.ctrl.ScrollMinX = 0;
            this.ctrl.ScrollMinY = 0;
            this.ctrl.ScrollMinY2 = 0;
            this.ctrl.Size = new System.Drawing.Size(623, 418);
            this.ctrl.TabIndex = 0;
            // 
            // btnDraw
            // 
            this.btnDraw.Location = new System.Drawing.Point(683, 361);
            this.btnDraw.Margin = new System.Windows.Forms.Padding(4, 4, 4, 4);
            this.btnDraw.Name = "btnDraw";
            this.btnDraw.Size = new System.Drawing.Size(132, 26);
            this.btnDraw.TabIndex = 1;
            this.btnDraw.Text = "Draw";
            this.btnDraw.UseVisualStyleBackColor = true;
            this.btnDraw.Click += new System.EventHandler(this.btnDraw_Click);
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(657, 20);
            this.label1.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(104, 17);
            this.label1.TabIndex = 3;
            this.label1.Text = "Count of nodes";
            // 
            // cmbNodes
            // 
            this.cmbNodes.FormattingEnabled = true;
            this.cmbNodes.Items.AddRange(new object[] {
            "3",
            "7",
            "9",
            "17",
            "21",
            "33",
            "65",
            "135"});
            this.cmbNodes.Location = new System.Drawing.Point(665, 42);
            this.cmbNodes.Margin = new System.Windows.Forms.Padding(4, 4, 4, 4);
            this.cmbNodes.Name = "cmbNodes";
            this.cmbNodes.Size = new System.Drawing.Size(151, 24);
            this.cmbNodes.TabIndex = 4;
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(661, 71);
            this.label2.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(58, 17);
            this.label2.TabIndex = 5;
            this.label2.Text = "Epsylon";
            // 
            // cmbEpsylon
            // 
            this.cmbEpsylon.FormattingEnabled = true;
            this.cmbEpsylon.Items.AddRange(new object[] {
            "1",
            "0,5",
            "0,05",
            "0,005"});
            this.cmbEpsylon.Location = new System.Drawing.Point(663, 91);
            this.cmbEpsylon.Margin = new System.Windows.Forms.Padding(4, 4, 4, 4);
            this.cmbEpsylon.Name = "cmbEpsylon";
            this.cmbEpsylon.Size = new System.Drawing.Size(148, 24);
            this.cmbEpsylon.TabIndex = 6;
            // 
            // btnExit
            // 
            this.btnExit.Location = new System.Drawing.Point(683, 411);
            this.btnExit.Margin = new System.Windows.Forms.Padding(4, 4, 4, 4);
            this.btnExit.Name = "btnExit";
            this.btnExit.Size = new System.Drawing.Size(135, 27);
            this.btnExit.TabIndex = 7;
            this.btnExit.Text = "Exit";
            this.btnExit.UseVisualStyleBackColor = true;
            this.btnExit.Click += new System.EventHandler(this.btnExit_Click);
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(664, 127);
            this.label3.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(39, 17);
            this.label3.TabIndex = 8;
            this.label3.Text = "Task";
            // 
            // cmbTask
            // 
            this.cmbTask.FormattingEnabled = true;
            this.cmbTask.Items.AddRange(new object[] {
            "Task#1",
            "Task#2"});
            this.cmbTask.Location = new System.Drawing.Point(669, 150);
            this.cmbTask.Margin = new System.Windows.Forms.Padding(4, 4, 4, 4);
            this.cmbTask.Name = "cmbTask";
            this.cmbTask.Size = new System.Drawing.Size(143, 24);
            this.cmbTask.TabIndex = 9;
            // 
            // FrmLabs1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(857, 465);
            this.Controls.Add(this.cmbTask);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.btnExit);
            this.Controls.Add(this.cmbEpsylon);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.cmbNodes);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.btnDraw);
            this.Controls.Add(this.ctrl);
            this.Margin = new System.Windows.Forms.Padding(4, 4, 4, 4);
            this.Name = "FrmLabs1";
            this.Text = "Interpolation";
            this.Load += new System.EventHandler(this.FrmLabs1_Load);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private ZedGraph.ZedGraphControl ctrl;
        private System.Windows.Forms.Button btnDraw;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.ComboBox cmbNodes;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.ComboBox cmbEpsylon;
        private System.Windows.Forms.Button btnExit;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.ComboBox cmbTask;
    }
}

