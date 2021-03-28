package com.zetcode;

import javax.swing.*;
import java.awt.*;

class Surface extends JPanel {
    public Surface() { }

    void bezier(int[][] x, int[][] y, Graphics2D g2d){
        double t;
        BasicStroke b = new BasicStroke(6, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL);
        g2d.setColor(Color.black);
        
        
        for(int a=1;a<x.length;a++){
            for(t=0.0;t<1.0;t+=0.01){
                double xt= Math.pow(1-t,3)*x[a-1][2] + 3*t*Math.pow(1-t,2)*x[a][0] + 3*Math.pow(t,2)*(1-t)*x[a][1] + Math.pow(t,3)*x[a][2];
                double yt= Math.pow(1-t,3)*y[a-1][2] + 3*t*Math.pow(1-t,2)*y[a][0] + 3*Math.pow(t,2)*(1-t)*y[a][1] + Math.pow(t,3)*y[a][2];

                g2d.drawLine((int)xt,(int)yt,(int)xt,(int)yt);
            }
        }

    }
    private void doDrawing(Graphics g) {
         Graphics2D g2d = (Graphics2D) g.create();
        g2d.setPaint(Color.blue);
        int xnoff = 150; 
        int ynoff = -30;
        int xmoff = -50;
        int ymoff = -30;

int[][] xm = new int[][]{ 
                { 0          ,  0          ,  104 + xmoff  },
                { 104 + xmoff,  103 + xmoff,  111 + xmoff },
                { 129 + xmoff,  186 + xmoff,  178 + xmoff },
                { 170 + xmoff,  223 + xmoff,  238 + xmoff },
                { 250 + xmoff,  252 + xmoff,  249 + xmoff },
                { 247 + xmoff,  225 + xmoff,  226 + xmoff },
                { 228 + xmoff,  230 + xmoff,  218 + xmoff },
                { 197 + xmoff,  186 + xmoff,  177 + xmoff },
		{ 168 + xmoff,  154 + xmoff,  139 + xmoff },
		{ 121 + xmoff,  139 + xmoff , 130 + xmoff },
		{ 123 + xmoff,  122 + xmoff , 107 + xmoff}};

int[][] ym = new int[][]{ 
                { 0          ,  0          ,  386 + ymoff },
                { 401 + ymoff,  163 + ymoff,  150 + ymoff },
                { 119 + ymoff,  258 + ymoff,  271 + ymoff },
                { 284 + ymoff,  149 + ymoff,  151 + ymoff },
                { 153 + ymoff,  359 + ymoff,  385 + ymoff },
                { 400 + ymoff,  396 + ymoff,  381 + ymoff },
                { 347 + ymoff,  221 + ymoff,  230 + ymoff },
                { 245 + ymoff,  303 + ymoff,  315 + ymoff },
		{ 327 + ymoff,  234 + ymoff,  231 + ymoff },
		{ 227 + ymoff,  368 + ymoff,  384 + ymoff },
		{ 396 + ymoff,  390 + ymoff,  389 + ymoff }};


int[][] xn = new int[][]{ 
                { 0          ,   0         ,  94 + xnoff  },
                { 93 + xnoff ,   95 + xnoff,  100 + xnoff },
                { 110 + xnoff, 	117 + xnoff,  114 + xnoff },
                { 111 + xnoff, 	177 + xnoff,  184 + xnoff },
                { 197 + xnoff,  198 + xnoff,  196 + xnoff },
                { 194 + xnoff,  199 + xnoff,  203 + xnoff },
                { 208 + xnoff, 	223 + xnoff,  224 + xnoff },
                { 226 + xnoff,  216 + xnoff,  210 + xnoff },
                { 206 + xnoff, 	185 + xnoff,  180 + xnoff },
		{ 174 + xnoff, 	123 + xnoff,  121 + xnoff },
		{ 119 + xnoff,	129 + xnoff,  118 + xnoff },
		{ 113 + xnoff, 	103 + xnoff,  94 + xnoff  }};

int[][] yn = new int[][]{ 
                { 0          ,  0          ,  367 + ynoff },
                { 387 + ynoff,  172 + ynoff,  160 + ynoff },
                { 137 + ynoff,  170 + ynoff,  155 + ynoff },
                { 140 + ynoff,  318 + ynoff,  332 + ynoff },
                { 359 + ynoff,  315 + ynoff,  330 + ynoff },
                { 345 + ynoff,  179 + ynoff,  165 + ynoff },
                { 147 + ynoff,  154 + ynoff,  169 + ynoff },
                { 196 + ynoff,  342 + ynoff,  365 + ynoff }, 
                { 381 + ynoff,  387 + ynoff,  373 + ynoff },
		{ 355 + ynoff,  232 + ynoff,  217 + ynoff },
		{ 202 + ynoff,  339 + ynoff,  367 + ynoff },
		{ 381 + ynoff,  380 + ynoff,  368 + ynoff }};

        
        bezier(xn, yn, g2d);
        bezier(xm, ym, g2d);
     
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }
}

class PointsE extends JFrame {
    public PointsE() {
        initUI();
    }

    private void initUI() {
        final com.zetcode.Surface surface = new com.zetcode.Surface();
        add(surface);

        setTitle("Krzywe Bezier'a");
        setSize(640, 450);
        setMinimumSize(new Dimension(640,450));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            PointsE ex = new PointsE();
            ex.setVisible(true);
        });
    }
}
