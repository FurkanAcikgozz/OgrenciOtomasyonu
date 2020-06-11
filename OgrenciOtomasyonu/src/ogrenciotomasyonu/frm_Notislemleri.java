
package ogrenciotomasyonu;

import java.sql.DriverManager;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import static ogrenciotomasyonu.frm_Ogrenciislemleri.DB_URL;


public class frm_Notislemleri extends javax.swing.JFrame {

    public frm_Notislemleri() {
        initComponents();
        TabloDoldur();
        TabloDolduGuncelle();
    }
    static final String JDBC_DRIVER="com.mysql.jdbc.Driver";
    static final String DOMAIN_NAME="localhost:3306";
    static final String DB_NAME="ogr_oto?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey";
    static final String DB_URL="jdbc:mysql://"+DOMAIN_NAME+"/"+DB_NAME;
    static final String USER="root";
    static final String PASS="1234";
    
    private Connection conn =null;
    
    public Statement BaglantiAc() throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        conn=DriverManager.getConnection(DB_URL,USER,PASS);
        return (Statement)conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
        }
     
    public void BaglantiKapat() throws Exception{
        conn.close();
     }
    
    private void TabloDoldur(){
        Connection conn=null;
        try {
        Class.forName("com.mysql.jdbc.Driver");
        conn=DriverManager.getConnection(DB_URL,USER,PASS);
        String sql="select * from ogr_no";
        PreparedStatement patmt;
        patmt = conn.prepareStatement(sql);
        ResultSet rs=patmt.executeQuery();
        
        table_Ekle.setModel(DbUtils.resultSetToTableModel(rs));
        conn.close();
            
        } 
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            
        }
    }
    
    private void TabloDolduGuncelle(){
        Connection conn=null;
        try {
        Class.forName("com.mysql.jdbc.Driver");
        conn=DriverManager.getConnection(DB_URL,USER,PASS);
        String sql="select * from ogr_no";
        PreparedStatement patmt;
        patmt = conn.prepareStatement(sql);
        ResultSet rs=patmt.executeQuery();
        
        table_Duzenle.setModel(DbUtils.resultSetToTableModel(rs));
        conn.close();
            
        } 
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            
        }
    }
    
    private void TabloDoldurAra(){
        Connection conn=null;
        try {
        Class.forName("com.mysql.jdbc.Driver");
        conn=DriverManager.getConnection(DB_URL,USER,PASS);
        String sql="select * from ogr_no";
        PreparedStatement patmt;
        patmt = conn.prepareStatement(sql);
        ResultSet rs=patmt.executeQuery();

        table_Ara.setModel(DbUtils.resultSetToTableModel(rs));
        conn.close();
        } 
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);  
        }
     }
    
    public void NotEkle(String no, String ad, String ders, int vize, int finl, String ortalama)throws Exception{
       
        try {
            
            Statement st=BaglantiAc();
            
            String sqlkomut="INSERT INTO ogr_no (OkulNO, AdSoyad, Ders, Vize, Final, Ortalama) VALUES ("+
            "'"+no+ "'," + 
            "'"+ad+"',"+
            "'"+ders+"',"+
            "'"+vize+"',"+
            "'"+finl+"',"+
            "'"+ortalama+"')";
            st.executeUpdate(sqlkomut);
            BaglantiKapat();
            TabloDoldur();
            JOptionPane.showMessageDialog(null, "Yeni Kayıt Eklendi");

            } 
        catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e,"Not Ekleme",JOptionPane.PLAIN_MESSAGE);
            
        }
    }

    public void NotGuncelle(String no, String ad, String ders, int vize, int finl, String ortalama, String eskiNo){
        try {
            Statement st=BaglantiAc();
            
            String sqlkomut="UPDATE ogr_oto.ogr_no SET "+
            "OkulNO='"+no+ "'," + 
            "AdSoyad='"+ad+"',"+
            "Ders='"+ders+"',"+
            "Vize='"+vize+"',"+
            "Final='"+finl+"',"+
            "Ortalama='"+ortalama+"'"+
            "WHERE OkulNO="+eskiNo;
            
            st.executeUpdate(sqlkomut);
            BaglantiKapat();
            TabloDolduGuncelle();
            JOptionPane.showMessageDialog(null, "Yeni Not Güncellendi");
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e,"Not Güncelleme",JOptionPane.PLAIN_MESSAGE);

        }
    }
     public void kayitAra(String no){
        Connection conn=null;
        try {
        Class.forName("com.mysql.jdbc.Driver");
        conn=DriverManager.getConnection(DB_URL,USER,PASS);
        String sql=("select * from ogr_no WHERE OkulNO=")+no;
        PreparedStatement patmt;
        patmt = conn.prepareStatement(sql);
        ResultSet rs=patmt.executeQuery();

        table_Ara.setModel(DbUtils.resultSetToTableModel(rs));
        conn.close();
        } 
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);  
        }
  
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        txt_NoEkle = new javax.swing.JTextField();
        txt_AdEkle = new javax.swing.JTextField();
        com_DersEkle = new javax.swing.JComboBox<>();
        txt_VizeEkle = new javax.swing.JTextField();
        txt_FinalEkle = new javax.swing.JTextField();
        txt_OrtalamaEkle = new javax.swing.JTextField();
        btn_Ekle = new javax.swing.JButton();
        scroll_Ekle = new javax.swing.JScrollPane();
        table_Ekle = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txt_NoDuzenle = new javax.swing.JTextField();
        txt_AdDuzenle = new javax.swing.JTextField();
        com_DersDuzenle = new javax.swing.JComboBox<>();
        txt_VizeDuzenle = new javax.swing.JTextField();
        txt_FinalDuzenle = new javax.swing.JTextField();
        btn_NotDuzenle = new javax.swing.JButton();
        scroll_Duzenle = new javax.swing.JScrollPane();
        table_Duzenle = new javax.swing.JTable();
        label_Ort = new javax.swing.JLabel();
        btn_OrtHesapla = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        scroll_ara = new javax.swing.JScrollPane();
        table_Ara = new javax.swing.JTable();
        btn_Ara = new javax.swing.JButton();
        txt_Ara = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.setBackground(new java.awt.Color(0, 51, 51));
        jTabbedPane1.setForeground(new java.awt.Color(0, 255, 255));

        jPanel1.setBackground(new java.awt.Color(153, 255, 153));

        com_DersEkle.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Matematik", "Fizik", "Kimya" }));

        btn_Ekle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ogrenciotomasyonu/Button-Add-icon.png"))); // NOI18N
        btn_Ekle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_EkleActionPerformed(evt);
            }
        });

        table_Ekle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        scroll_Ekle.setViewportView(table_Ekle);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ogrenciotomasyonu/Calculator-icon (1).png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ogrenciotomasyonu/Windows-Close-Program-icon.png"))); // NOI18N
        jButton2.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/ogrenciotomasyonu/close.jpg"))); // NOI18N
        jButton2.setDisabledSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/ogrenciotomasyonu/close.jpg"))); // NOI18N
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton2.setMargin(new java.awt.Insets(1, 1, 1, 1));
        jButton2.setMaximumSize(new java.awt.Dimension(100, 100));
        jButton2.setMinimumSize(new java.awt.Dimension(100, 100));
        jButton2.setPreferredSize(new java.awt.Dimension(100, 100));
        jButton2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/ogrenciotomasyonu/close.jpg"))); // NOI18N
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Snap ITC", 3, 14)); // NOI18N
        jLabel13.setText("Okul No:");

        jLabel14.setFont(new java.awt.Font("Snap ITC", 3, 14)); // NOI18N
        jLabel14.setText("Ad Soyad:");

        jLabel15.setFont(new java.awt.Font("Snap ITC", 3, 14)); // NOI18N
        jLabel15.setText("Ders:");

        jLabel17.setFont(new java.awt.Font("Snap ITC", 3, 14)); // NOI18N
        jLabel17.setText("Vize:");

        jLabel18.setFont(new java.awt.Font("Snap ITC", 3, 14)); // NOI18N
        jLabel18.setText("Final:");

        jLabel19.setFont(new java.awt.Font("Snap ITC", 3, 14)); // NOI18N
        jLabel19.setText("Ortalama:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                                .addGap(129, 129, 129))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel19)
                                            .addComponent(jLabel17)
                                            .addComponent(jLabel18)
                                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(1, 1, 1))
                                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txt_NoEkle)
                                        .addComponent(txt_AdEkle)
                                        .addComponent(com_DersEkle, 0, 112, Short.MAX_VALUE)
                                        .addComponent(txt_VizeEkle)
                                        .addComponent(txt_FinalEkle))
                                    .addComponent(txt_OrtalamaEkle, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(67, 67, 67)))))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_Ekle, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)))
                .addComponent(scroll_Ekle, javax.swing.GroupLayout.PREFERRED_SIZE, 703, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(txt_NoEkle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(txt_AdEkle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(com_DersEkle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(txt_VizeEkle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(txt_FinalEkle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(txt_OrtalamaEkle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_Ekle, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scroll_Ekle, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Not Gir", jPanel1);

        jPanel4.setBackground(new java.awt.Color(255, 255, 204));

        jLabel7.setFont(new java.awt.Font("Snap ITC", 3, 14)); // NOI18N
        jLabel7.setText("Okul No:");

        jLabel8.setFont(new java.awt.Font("Snap ITC", 3, 14)); // NOI18N
        jLabel8.setText("Ad Soyad:");

        jLabel9.setFont(new java.awt.Font("Snap ITC", 3, 14)); // NOI18N
        jLabel9.setText("Ders:");

        jLabel10.setFont(new java.awt.Font("Snap ITC", 3, 14)); // NOI18N
        jLabel10.setText("Vize:");

        jLabel11.setFont(new java.awt.Font("Snap ITC", 3, 14)); // NOI18N
        jLabel11.setText("Final:");

        jLabel12.setFont(new java.awt.Font("Snap ITC", 3, 14)); // NOI18N
        jLabel12.setText("Ortalama:");

        com_DersDuzenle.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Matematik", "Fizik", "Kimya" }));

        btn_NotDuzenle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ogrenciotomasyonu/Edit-Document-icon.png"))); // NOI18N
        btn_NotDuzenle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_NotDuzenleActionPerformed(evt);
            }
        });

        scroll_Duzenle.setBackground(new java.awt.Color(255, 255, 204));
        scroll_Duzenle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                scroll_DuzenleMousePressed(evt);
            }
        });

        table_Duzenle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        table_Duzenle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                table_DuzenleMousePressed(evt);
            }
        });
        scroll_Duzenle.setViewportView(table_Duzenle);

        btn_OrtHesapla.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ogrenciotomasyonu/Calculator-icon (1).png"))); // NOI18N
        btn_OrtHesapla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_OrtHesaplaActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ogrenciotomasyonu/Windows-Close-Program-icon.png"))); // NOI18N
        jButton3.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/ogrenciotomasyonu/close.jpg"))); // NOI18N
        jButton3.setDisabledSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/ogrenciotomasyonu/close.jpg"))); // NOI18N
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton3.setMargin(new java.awt.Insets(1, 1, 1, 1));
        jButton3.setMaximumSize(new java.awt.Dimension(100, 100));
        jButton3.setMinimumSize(new java.awt.Dimension(100, 100));
        jButton3.setPreferredSize(new java.awt.Dimension(100, 100));
        jButton3.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/ogrenciotomasyonu/close.jpg"))); // NOI18N
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(18, 18, Short.MAX_VALUE)
                                        .addComponent(label_Ort, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(18, 18, 18))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(15, 15, 15)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txt_FinalDuzenle, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txt_VizeDuzenle, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(com_DersDuzenle, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_NoDuzenle, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_AdDuzenle, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(16, 16, 16))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(btn_NotDuzenle, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(53, 53, 53))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(btn_OrtHesapla, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(88, 88, 88)))))
                .addComponent(scroll_Duzenle, javax.swing.GroupLayout.PREFERRED_SIZE, 701, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_NoDuzenle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_AdDuzenle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(17, 17, 17)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(com_DersDuzenle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txt_VizeDuzenle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txt_FinalDuzenle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(label_Ort))
                        .addGap(18, 18, 18)
                        .addComponent(btn_OrtHesapla, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_NotDuzenle))
                    .addComponent(scroll_Duzenle, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Not Düzenle", jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 233, 233));

        table_Ara.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        scroll_ara.setViewportView(table_Ara);

        btn_Ara.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ogrenciotomasyonu/Search-icon.png"))); // NOI18N
        btn_Ara.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AraActionPerformed(evt);
            }
        });

        jLabel16.setBackground(new java.awt.Color(0, 0, 0));
        jLabel16.setFont(new java.awt.Font("Snap ITC", 3, 13)); // NOI18N
        jLabel16.setText("Aramak İstediğiniz Öğrencinin T.C. Giriniz");

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ogrenciotomasyonu/Windows-Close-Program-icon.png"))); // NOI18N
        jButton4.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/ogrenciotomasyonu/close.jpg"))); // NOI18N
        jButton4.setDisabledSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/ogrenciotomasyonu/close.jpg"))); // NOI18N
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton4.setMargin(new java.awt.Insets(1, 1, 1, 1));
        jButton4.setMaximumSize(new java.awt.Dimension(100, 100));
        jButton4.setMinimumSize(new java.awt.Dimension(100, 100));
        jButton4.setPreferredSize(new java.awt.Dimension(100, 100));
        jButton4.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/ogrenciotomasyonu/close.jpg"))); // NOI18N
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scroll_ara)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(272, Short.MAX_VALUE)
                .addComponent(jLabel16)
                .addGap(294, 294, 294)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(313, 313, 313)
                        .addComponent(txt_Ara, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(368, 368, 368)
                        .addComponent(btn_Ara, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_Ara, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_Ara, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scroll_ara, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Öğrenci Ara", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_EkleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_EkleActionPerformed
        
        
        String no=txt_NoEkle.getText();
        String ad=txt_AdEkle.getText();
        int vize=Integer.parseInt(txt_VizeEkle.getText());
        int finl=Integer.parseInt(txt_FinalEkle.getText());
        int ortalama=(int)((vize*0.4)+(finl*0.6));
        txt_OrtalamaEkle.setText(""+ortalama);
        String ort=txt_OrtalamaEkle.getText();

        String ders;
        if      (com_DersEkle.getSelectedIndex()==1) ders="Matematik";
        else if (com_DersEkle.getSelectedIndex()==2) ders="Fizik";
        else if (com_DersEkle.getSelectedIndex()==3) ders="Kimya";
        else                                         ders="     ";
        

        try {
            NotEkle(no, ad, ders, vize, finl, ort);
            TabloDoldur();
        } catch (Exception ex) {
            Logger.getLogger(frm_Ogrenciislemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_EkleActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        int vize=Integer.parseInt(txt_VizeEkle.getText());
        int finl=Integer.parseInt(txt_FinalEkle.getText());
        int ortalama=(int)((vize*0.4)+(finl*0.6));
        txt_OrtalamaEkle.setText(""+ortalama);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void scroll_DuzenleMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_scroll_DuzenleMousePressed
 
    }//GEN-LAST:event_scroll_DuzenleMousePressed

    private void btn_NotDuzenleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_NotDuzenleActionPerformed
        
        String eskiNo=table_Duzenle.getValueAt(table_Duzenle.getSelectedRow(),0).toString();
        String no=txt_NoDuzenle.getText();
        String ad=txt_AdDuzenle.getText();
        int vize=Integer.parseInt(txt_VizeDuzenle.getText());
        int finl=Integer.parseInt(txt_FinalDuzenle.getText());
        int ortalama=(int)((vize*0.4)+(finl*0.6));
        label_Ort.setText(""+ortalama);
        String ort=label_Ort.getText();

        String ders;
        
        if      (com_DersDuzenle.getSelectedIndex()==1) ders="Matematik";
        
        else if (com_DersDuzenle.getSelectedIndex()==2) ders="Fizik";
        
        else if (com_DersDuzenle.getSelectedIndex()==3) ders="Kimya";
        
        else                                            ders="     ";
        
        try {
            NotGuncelle(no, ad, ders, vize, finl,ort, eskiNo);
        } catch (Exception ex) {
            Logger.getLogger(frm_Ogrenciislemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_NotDuzenleActionPerformed

    private void table_DuzenleMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_DuzenleMousePressed
       
        String eskiNo=table_Duzenle.getValueAt(table_Duzenle.getSelectedRow(),0).toString();
        txt_NoDuzenle.setText(table_Duzenle.getValueAt(table_Duzenle.getSelectedRow(),0).toString());
        txt_AdDuzenle.setText(table_Duzenle.getValueAt(table_Duzenle.getSelectedRow(),1).toString());
        txt_VizeDuzenle.setText(table_Duzenle.getValueAt(table_Duzenle.getSelectedRow(),3).toString());
        txt_FinalDuzenle.setText(table_Duzenle.getValueAt(table_Duzenle.getSelectedRow(),4).toString());

        String ders=table_Duzenle.getValueAt(table_Duzenle.getSelectedRow(),2).toString();
        
        if (ders.equals("Matematik"))  com_DersDuzenle.setSelectedIndex(1);
        
        else if (ders.equals("Fizik")) com_DersDuzenle.setSelectedIndex(1);
        
        else if (ders.equals("Kimya")) com_DersDuzenle.setSelectedIndex(2); 
        
        else                           com_DersDuzenle.setSelectedIndex(0);
    }//GEN-LAST:event_table_DuzenleMousePressed

    private void btn_OrtHesaplaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_OrtHesaplaActionPerformed
        int vize=Integer.parseInt(txt_VizeDuzenle.getText());
        int finl=Integer.parseInt(txt_FinalDuzenle.getText());
        int ortalama=(int)((vize*0.4)+(finl*0.6));
        label_Ort.setText(""+ortalama);
    }//GEN-LAST:event_btn_OrtHesaplaActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        System.exit(0);

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btn_AraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AraActionPerformed
        String no=txt_Ara.getText();
        kayitAra(no);
    }//GEN-LAST:event_btn_AraActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_Notislemleri().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Ara;
    private javax.swing.JButton btn_Ekle;
    private javax.swing.JButton btn_NotDuzenle;
    private javax.swing.JButton btn_OrtHesapla;
    private javax.swing.JComboBox<String> com_DersDuzenle;
    private javax.swing.JComboBox<String> com_DersEkle;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel label_Ort;
    private javax.swing.JScrollPane scroll_Duzenle;
    private javax.swing.JScrollPane scroll_Ekle;
    private javax.swing.JScrollPane scroll_ara;
    private javax.swing.JTable table_Ara;
    private javax.swing.JTable table_Duzenle;
    private javax.swing.JTable table_Ekle;
    private javax.swing.JTextField txt_AdDuzenle;
    private javax.swing.JTextField txt_AdEkle;
    private javax.swing.JTextField txt_Ara;
    private javax.swing.JTextField txt_FinalDuzenle;
    private javax.swing.JTextField txt_FinalEkle;
    private javax.swing.JTextField txt_NoDuzenle;
    private javax.swing.JTextField txt_NoEkle;
    private javax.swing.JTextField txt_OrtalamaEkle;
    private javax.swing.JTextField txt_VizeDuzenle;
    private javax.swing.JTextField txt_VizeEkle;
    // End of variables declaration//GEN-END:variables

}
