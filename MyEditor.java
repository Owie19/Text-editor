import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class MyEditor implements ActionListener {
 
    JFrame jf;
     JPanel panel;
    JLabel jl,jlo;
    JTextField jtf;
    JTextArea jta,jta1;
   
    JScrollPane jsp,jsp1;
    Runtime r;
    String str="";
    String fname="";
    String result="";
    String result1="";
    
    JMenuBar jmb;
    JMenu file,edit,option,setting;
    JMenuItem cut,copy,paste,selectAll,Compile,run,open,save,saveas,newfile;
    MyEditor() 
    {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(MyEditor.class.getName()).log(Level.SEVERE, null, ex);
        }

       
          jf=new JFrame("Java Mini IDE");
          jf.setLayout(null);
         jmb=new JMenuBar();
        //menubar
        
        cut=new JMenuItem("cut");    
        copy=new JMenuItem("copy");    
        paste=new JMenuItem("paste");    
        selectAll=new JMenuItem("selectAll");  
        Compile=new JMenuItem("Compile");
        run=new JMenuItem("Run");
        newfile =new JMenuItem("New File");
        open=new JMenuItem("Open");
        saveas=new JMenuItem("SaveAs");
        save=new JMenuItem("Save");
        
        cut.addActionListener(this);    
        copy.addActionListener(this);    
        paste.addActionListener(this);    
        selectAll.addActionListener(this); 
        Compile.addActionListener(this);
        run.addActionListener(this);
        open.addActionListener(this);
        newfile.addActionListener(this);
        save.addActionListener(this);
        saveas.addActionListener(this);
        
            
        file=new JMenu("File");    
        edit=new JMenu("Edit");
        option=new JMenu("Options");
        setting=new JMenu("Help");  
        edit.add(cut);
        edit.add(copy);
        edit.add(paste);
        edit.add(selectAll);
        option.add(Compile);
        option.add(run);
        jmb.add(file);
        jmb.add(edit);
        jmb.add(option);
        jmb.add(setting);
        file.add(newfile);
        file.add(open);
        file.add(save);
        file.add(saveas);
        
        jf.setJMenuBar(jmb); 
        jf.add(jmb);
      
        jlo=new JLabel("OUTPUT");
        jf.add(jlo);
        
        jl=new JLabel("Enter your main class name:");
        jl.setBounds(5,50,200, 25);
        jtf=new JTextField();
        jtf.setBounds(200,50,130,25);
        jta=new JTextArea(60,60);
        jta1=new JTextArea(50,50);
        jta.setFont(new Font("Varinda",Font.PLAIN,15));
        jta1.setEditable(false);
        jta1.setFont(new Font("Varinda",Font.PLAIN,15));
        jsp=new JScrollPane(jta);
        jsp1=new JScrollPane(jta1);
        jsp.setBounds(5,85,700,550);
        jsp1.setBounds(750,85,600,550);
        jlo.setBounds(1050,65,200,25);
        jf.add(jsp);
        jf.add(jsp1);
       
        jf.add(jl);
        jf.add(jtf);
        r=  Runtime.getRuntime();
     
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setBounds(0,0,1380,700);
        
        jf.setVisible(true);
        
        jf.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("1.png")));
      
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==cut)    
         jta.cut();    
        else if(e.getSource()==paste)    
        jta.paste();    
        else if(e.getSource()==copy)    
        jta.copy();    
        else if(e.getSource()==selectAll)    
        jta.selectAll();    
         
        else if(e.getSource()==newfile)
        {
         jta.setText(null);
         jta1.setText(null);
         jtf.setText(null);
        }
        //file chooser (open)
        
        if(e.getSource()==open){    
        JFileChooser fc=new JFileChooser();
        fc.setDialogTitle("Select an image");
      
        
        int i=fc.showOpenDialog(jf);
        fc.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("text and java files", "txt", "java");
        fc.addChoosableFileFilter(filter);
        
        if(i==JFileChooser.APPROVE_OPTION){    
        File f=fc.getSelectedFile();    
        String filepath=f.getPath();    
        try{  
        BufferedReader br=new BufferedReader(new FileReader(filepath));    
        String s1="",s2="";                         
        while((s1=br.readLine())!=null){    
        s2+=s1+"\n";    
        }    
        jta.setText(s2);    
        br.close();    
        }catch (Exception ex) {ex.printStackTrace();  }                 
    }    
}    
        
        else if(e.getSource()==Compile)
        {   
           String dir = System.getProperty("user.dir");
            str="";
            if(!jtf.getText().equals(""))
            {
                try
                {
                fname=jtf.getText().trim()+".java";
                FileWriter fw = new FileWriter(fname);
                String s1 = jta.getText();
                PrintWriter pw = new PrintWriter(fw);
                pw.println(s1);
                pw.flush();
                Process error = r.exec("C:\\Program Files\\Java\\jdk1.8.0_151\\bin\\javac.exe  "+dir+"\\"+fname);
            
               BufferedReader err = new BufferedReader(new InputStreamReader(error.getErrorStream()));
                while(true)
                {
                    String temp = err.readLine();
                    if(temp!=null)
                    {
                        result=result+temp;
                        result=result+"\n";
                               
                    }
                    else break;
                }
                if(result.equals(""))
                {
                    jta1.setText("compilation successfull : "+fname);
                    err.close();
                }
                else
                    jta1.setText(result);
                }
                catch(Exception e1)
                {
                    System.out.println("e1");
                }
                
            }
            else
                jta1.setText("please enter your program name");
        }
        
        else if(e.getSource()==run)
        {
            String dir = System.getProperty("user.dir");
            int start=0;
            try
            {
                String fn=jtf.getText().trim();
                Process p = r.exec("C:\\Program Files\\Java\\jdk1.8.0_151\\bin\\java "+fn);
                BufferedReader output = new BufferedReader(new InputStreamReader(p.getInputStream()));
                BufferedReader error = new BufferedReader(new InputStreamReader(p.getErrorStream()));
                while(true)
                {
                    String temp = output.readLine();
                    if(temp!=null)
                    {
                        result=result+temp;
                        result=result+"\n";
                        
                    }
                    else break;
                }
                while(true)
                {
                    String temp=error.readLine();
                    if(temp!=null)
                    {
                        result=result+temp;
                        result=result+"\n";
                    }
                    else break;
                }
                output.close();
                error.close();
                jta1.setText(result+"\n"+result1);
            }
            catch(Exception e2)
            {
                System.out.println("e2");
            }
        }
    }
    
    
    public static void main(String[] args)
    {
     new MyEditor();
    }
}