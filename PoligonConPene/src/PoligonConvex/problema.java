
package PoligonConvex;


class Point {
    
    
        int x; 
        int y; 
  
        public Point(int x, int y) 
        { 
            this.x = x; 
            this.y = y; 
        } 
     
    
    public static void translatie(Point poligon[],Point s,int j){
        int i=0;
        while(i<j)
        {
            poligon[i].x=poligon[i].x-s.x;
            poligon[i].y=poligon[i].y-s.y;
            i++;
        }
    }
    
    public static void cadranul(Point poligon[],int cadran[],int i)
    {
        int j=0;
        while(j<i)
        {
            if(poligon[j].x>0&&poligon[j].y>=0) cadran[j]=1;
            else if(poligon[j].x<=0&&poligon[j].y>0) cadran[j]=2;
            else if(poligon[j].x<0&&poligon[j].y<=0) cadran[j]=3;
            else if(poligon[j].x>=0&&poligon[j].y<0) cadran[j]=4;
            
            i++;
        }
        
    }
    

  
    
    public static int verifica(Point p[],Point x,int n)
    {
        int c = 0,c1=1000;
        for(int i=0;i<n-1;i++)
        {
            c=p[i].x*x.y+x.x*p[i+1].y+p[i].y*p[1].x-p[i+1].x*x.y-x.x*p[i].y-p[i+1].y*p[i].x;
            if(c1<c)c1=c;
            
        }
        if(c1==0)c=2;
        if(c1<0)c= 1;
        if(c1>0)c=3 ;
        
        return c;
    }
    
    public static void main(String[] args) {
        
        Point poligon[] = {new Point(0, 5), 
                            new Point(10, 0), 
                            new Point(5, 5),
                            new Point(10, 10),  
                            new Point(0, 10)};
        
        Point x=new Point(2,3);//punctul ce trebuie sa verificam
        
        int k=1;
        int n = poligon.length;
        int[] cadran=new int[n];
        Point s=new Point((poligon[0].x+poligon[1].x+poligon[2].x)/3,(poligon[0].y+poligon[1].y+poligon[2].y)/3);
        
        
        //translatie pct x
        x.x=x.x-s.x;
        x.y=x.y-s.y;
        
        
        translatie(poligon,s,n);
        cadranul(poligon,cadran,n);
        
        
        
        while(k!=0)
        {
        Point q=new Point(0,0);
        int c;
        
        for(int i=0;i<n-1;i++)
        {
            if(cadran[i]>cadran[i+1])
            {
                q.x=poligon[i].x;
                poligon[i].x=poligon[i+1].x;
                poligon[i+1].x=q.x;
                
                q.y=poligon[i].y;
                poligon[i].y=poligon[i+1].y;
                poligon[i+1].y=q.y;
                
                c=cadran[i];
                cadran[i]=cadran[i+1];
                cadran[i+1]=c;
                
                
            }
            else if((cadran[i]==cadran[i+1])&&((poligon[i+1].x*poligon[i].y)-(poligon[i].x*poligon[i+1].y))<0)
            {
                q.x=poligon[i].x;
                poligon[i].x=poligon[i+1].x;
                poligon[i+1].x=q.x;
                
                q.y=poligon[i].y;
                poligon[i].y=poligon[i+1].y;
                poligon[i+1].y=q.y;
                
                c=cadran[i];
                cadran[i]=cadran[i+1];
                cadran[i+1]=c;
                
            }
            else k=0;
        
            
        } 
        }
        
        
        
        k=verifica(poligon,x,n);
        
        
        if(k==2)System.out.println("Pe granita");
        if(k==1)System.out.println("Interior");
        if(k==3)System.out.println("Exterior");
        
        
        
        
        
        
        
        
        
        
    }
    
    
}
