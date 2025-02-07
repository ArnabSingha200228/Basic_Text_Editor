import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.filechooser.*;
class MyNotepad
{
  JTextArea jta;
  JButton bnew,savas,save,open,pl,mn;
  JFrame jf;
  JLabel jl;
  JCheckBox jc;
  Font fnt;
  File of;
  boolean sf;
  MyNotepad()
  {
    sf=false;
    jf=new JFrame("My Notepad");
    JPanel p=new JPanel();
    jc=new JCheckBox("Read-only");
    jl=new JLabel("Hi!  Start typing...");
    jta=new JTextArea();
    fnt=new Font("calibri",Font.PLAIN,20);
    save=new JButton("Save");
    bnew=new JButton("New");
    savas=new JButton("Save as");
    open=new JButton("Open");
    pl=new JButton("Font +");
    mn=new JButton("Font -");
    open.setFont(new Font("calibri",Font.PLAIN,15));
    save.setFont(new Font("calibri",Font.PLAIN,15));
    savas.setFont(new Font("calibri",Font.PLAIN,15));
    pl.setFont(new Font("calibri",Font.PLAIN,15));
    mn.setFont(new Font("calibri",Font.PLAIN,15));
    bnew.setFont(new Font("calibri",Font.PLAIN,15));
    jl.setFont(new Font("calibri",Font.PLAIN,13));
    jta.setFont(fnt);
    p.setLayout(new FlowLayout(FlowLayout.LEFT));
    p.add(bnew);
    p.add(open);
    p.add(save);
    p.add(savas);
    p.add(pl);
    p.add(mn);
    p.add(jc);
    JScrollPane scr=new JScrollPane(jta);
    jf.setLayout(new BorderLayout());
    jf.add(p,BorderLayout.NORTH);
    jf.add(scr,BorderLayout.CENTER);
    jf.add(jl,BorderLayout.SOUTH);
    jf.setSize(800,500);
    jf.setVisible(true);
    jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    pl.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e)
      {
        int s=fnt.getSize();
        fnt=new Font("calibri",Font.PLAIN,s+2);
        jta.setFont(fnt);
      }
    });
    mn.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e)
      {
        int s=fnt.getSize();
        fnt=new Font("calibri",Font.PLAIN,s-2);
        jta.setFont(fnt);
      }
    });
    bnew.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e)
      {
        jta.setText("");
        jl.setText("Hi!  Start typing...");
        sf=false;
        of=null;
      }
    });
    open.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e)
      {
        JFileChooser jfc=new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        int v=jfc.showOpenDialog(jf);
        if(v==JFileChooser.APPROVE_OPTION)
        {
          try
          {
            String s="";
            String l;
            File f=jfc.getSelectedFile();
            of=f;
            jl.setText(f.getAbsolutePath());
            BufferedReader br=new BufferedReader(new FileReader(f));
            while((l=br.readLine())!=null)
              s+=l+"\n";
            jta.setText(s);
            sf=true;
          }
          catch(Exception ee)
          {
            JOptionPane.showMessageDialog(null,"Error!");
          }
        }
      }
    });
    save.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e)
      {
        if(!sf)
        {          
          JFileChooser jfc=new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
          int v=jfc.showSaveDialog(jf);
          if(v==JFileChooser.APPROVE_OPTION)
          {
            try
            {
              String s=jta.getText();
              File f=jfc.getSelectedFile();
              of=f;
              jl.setText(f.getAbsolutePath());
              FileOutputStream fs=new FileOutputStream(f);
              byte b[]=s.getBytes();
              fs.write(b);
              sf=true;
              JOptionPane.showMessageDialog(null,"File Saved!");
            }
            catch(Exception ee)
            {
              JOptionPane.showMessageDialog(null,"Error!");
            }
          }
        }
        else
        {
          try
          {
            String s=jta.getText();
            FileOutputStream fs=new FileOutputStream(of);
            byte b[]=s.getBytes();
            fs.write(b);
            sf=true;
            JOptionPane.showMessageDialog(null,"File Saved!");
          }
          catch(Exception ee)
          {
            JOptionPane.showMessageDialog(null,"Error!");
          }
        }
      }
    });
    savas.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e)
      {
        JFileChooser jfc=new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        int v=jfc.showSaveDialog(jf);
        if(v==JFileChooser.APPROVE_OPTION)
        {
          try
          {
            String s=jta.getText();
            File f=jfc.getSelectedFile();
            of=f;
            jl.setText(f.getAbsolutePath());
            FileOutputStream fs=new FileOutputStream(f);
            byte b[]=s.getBytes();
            fs.write(b);
            sf=true;
            JOptionPane_showMessageDialog(null,"File Saved!");
          }
          catch(Exception ee)
          {
            JOptionPane_showMessageDialog(null,"Error!");
          }
        }
      }
    });
    jc.addItemListener(new ItemListener(){
      public void itemStateChanged(ItemEvent e)
      {
        if(jc.isSelected())
          jta.setEnabled(false);
        else
          jta.setEnabled(true);
      }
    });
  }
  public static void main(String args[])
  {
    new MyNotpad();
  }
}
