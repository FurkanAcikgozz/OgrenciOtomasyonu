
package ogrenciotomasyonu;

import java.sql.DriverManager;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class frm_Ogrenciislemleri extends javax.swing.JFrame {

    public frm_Ogrenciislemleri() {
        initComponents();
        TabloDoldur();
        TabloDolduGuncelle();
        TabloDoldurSil();
    }
    static final String JDBC_DRIVER="com.mysql.jdbc.Driver";
    static final String DOMAIN_NAME="localhost:3306";
    static final String DB_NAME="ogr_oto?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey";
    static final String DB_URL="jdbc:mysql://"+DOMAIN_NAME+"/"+DB_NAME;
    static final String USER="root";
    static final String PASS="1234";
    
    private Connection conn =null;
    
     public void baglantikapa() throws Exception{
        conn.close();
     }
    
    public Statement baglantiac() throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        conn=DriverManager.getConnection(DB_URL,USER,PASS);
        return (Statement)conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
        }
   
    
    private void TabloDoldur(){
        Connection conn=null;
        try {
        Class.forName("com.mysql.jdbc.Driver");
        conn=DriverManager.getConnection(DB_URL,USER,PASS);
        String sql="select * from ogr_bilgileri";
        PreparedStatement patmt;
        patmt = conn.prepareStatement(sql);
        ResultSet rs=patmt.executeQuery();
        
        table_Ekle.setModel(DbUtils.resultSetToTableModel(rs));
        conn.close();
            
        } 
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Tablo Doldurulurken Hata Oluştu");
            
        }
    }
    
    private void TabloDolduGuncelle(){
        Connection conn=null;
        try {
        Class.forName("com.mysql.jdbc.Driver");
        conn=DriverManager.getConnection(DB_URL,USER,PASS);
        String sql="select * from ogr_bilgileri";
        PreparedStatement patmt;
        patmt = conn.prepareStatement(sql);
        ResultSet rs=patmt.executeQuery();
        
        table_Guncelle.setModel(DbUtils.resultSetToTableModel(rs));
        conn.close();
            
        } 
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Tablo Güncellenirken Hata Oluştu");
            
        }
    }
    
    private void TabloDoldurSil(){
        Connection conn=null;
        try {
        Class.forName("com.mysql.jdbc.Driver");
        conn=DriverManager.getConnection(DB_URL,USER,PASS);
        String sql="select * from ogr_bilgileri";
        PreparedStatement patmt;
        patmt = conn.prepareStatement(sql);
        ResultSet rs=patmt.executeQuery();

        table_Sil.setModel(DbUtils.resultSetToTableModel(rs));
        conn.close();
        } 
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Tablo Silinirken Hata Oluştu");  
        }
     }
    private void TabloDoldurAra(){
        Connection conn=null;
        try {
        Class.forName("com.mysql.jdbc.Driver");
        conn=DriverManager.getConnection(DB_URL,USER,PASS);
        String sql="select * from ogr_bilgileri";
        PreparedStatement patmt;
        patmt = conn.prepareStatement(sql);
        ResultSet rs=patmt.executeQuery();

        table_Ara.setModel(DbUtils.resultSetToTableModel(rs));
        conn.close();
        } 
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Tablo Doldurulurken Hata Oluştu");  
        }
     }
    
    public void KayitEkle(String tc, String ad, String dogumtarih, String tel, String fakulte, String bolum, String Mufredt)throws Exception{
       
        try {
            
            Statement st=baglantiac();
            
            String sqlkomut="INSERT INTO ogr_bilgileri (TC, AdSoyad, DogumTarihi, Telefon, Fakulte, Bolum, Mufredat) VALUES ("+
            "'"+tc+ "'," + 
            "'"+ad+"',"+
            "'"+dogumtarih+"',"+
            "'"+tel+"',"+
            "'"+fakulte+"',"+
            "'"+bolum+"',"+
            "'"+Mufredt+"')";
            st.executeUpdate(sqlkomut);
            baglantikapa();
            TabloDoldur();
            JOptionPane.showMessageDialog(null, "Yeni Kayıt Eklendi");

            } 
        catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Kayıt Eklenemedi","Kisiler Tablosu",JOptionPane.PLAIN_MESSAGE);
            
        }
    }
    
    public void kayitguncelle(String tc, String ad, String dogumtarih, String tel, String fakulte, String bolum, String Mufredt, String eskiTc){
        try {
            Statement st=baglantiac();
            
            String sqlkomut="UPDATE ogr_oto.ogr_bilgileri SET "+
            "TC='"+tc+ "'," + 
            "AdSoyad='"+ad+"',"+
            "DogumTarihi='"+dogumtarih+"',"+
            "Telefon='"+tel+"',"+
            "Fakulte='"+fakulte+"',"+
            "Bolum='"+bolum+"',"+
            "Mufredat='"+Mufredt+"'"+
            "WHERE TC="+eskiTc;
            
            st.executeUpdate(sqlkomut);
            baglantikapa();
            TabloDolduGuncelle();
            JOptionPane.showMessageDialog(null, "Yeni Kayıt Güncellendi");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hata Oluştu. Güncellenemedi");


        }
    }
    public void KayitSil(String tc){
        try {
            Statement st=baglantiac();
            st.executeUpdate("DELETE FROM ogr_oto.ogr_bilgileri where TC="+tc);
            baglantikapa();
            TabloDoldurSil();
            JOptionPane.showMessageDialog(null, "Kayıt Silindi");
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Kayıt Silinmedi","Hata",JOptionPane.PLAIN_MESSAGE);
        }
        
    }
    
    public void kayitAra(String tc){
        Connection conn=null;
        try {
        Class.forName("com.mysql.jdbc.Driver");
        conn=DriverManager.getConnection(DB_URL,USER,PASS);
        String sql=("select * from ogr_bilgileri WHERE TC=")+tc;
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
        panel_KayitEkle = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_TcEkle = new javax.swing.JTextField();
        txt_AdEkle = new javax.swing.JTextField();
        txt_DogumEkle = new javax.swing.JTextField();
        txt_TelEkle = new javax.swing.JTextField();
        com_FakulteEkle = new javax.swing.JComboBox<>();
        com_BolumEkle = new javax.swing.JComboBox<>();
        com_MufredatEkle = new javax.swing.JComboBox<>();
        btn_Ekle = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_Ekle = new javax.swing.JTable();
        jButton7 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        panel_Guncelle = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txt_TcGuncelle = new javax.swing.JTextField();
        txt_AdiGuncelle = new javax.swing.JTextField();
        txt_DogumGuncelle = new javax.swing.JTextField();
        txt_TelGuncelle = new javax.swing.JTextField();
        com_FakulteGuncelle = new javax.swing.JComboBox<>();
        com_BolumGuncelle = new javax.swing.JComboBox<>();
        com_MufredatGuncelle = new javax.swing.JComboBox<>();
        btn_Guncelle = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_Guncelle = new javax.swing.JTable();
        jButton6 = new javax.swing.JButton();
        panel_Sil = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        txt_KayitSil = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        table_Sil = new javax.swing.JTable();
        btn_Sil2 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        txt_Ara = new javax.swing.JTextField();
        btn_Ara = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        table_Ara = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.setBackground(new java.awt.Color(153, 153, 0));

        panel_KayitEkle.setBackground(new java.awt.Color(244, 232, 232));

        jLabel1.setFont(new java.awt.Font("Snap ITC", 3, 14)); // NOI18N
        jLabel1.setText("T.C.");

        jLabel2.setFont(new java.awt.Font("Snap ITC", 3, 14)); // NOI18N
        jLabel2.setText("Adı Soyadı:");

        jLabel3.setFont(new java.awt.Font("Snap ITC", 3, 14)); // NOI18N
        jLabel3.setText("Doğum Tarihi:");

        jLabel4.setFont(new java.awt.Font("Snap ITC", 3, 14)); // NOI18N
        jLabel4.setText("Telefon:");

        jLabel5.setFont(new java.awt.Font("Snap ITC", 3, 14)); // NOI18N
        jLabel5.setText("Fakülte:");

        jLabel6.setFont(new java.awt.Font("Snap ITC", 3, 14)); // NOI18N
        jLabel6.setText("Bölüm:");

        jLabel7.setFont(new java.awt.Font("Snap ITC", 3, 14)); // NOI18N
        jLabel7.setText("Müfredat:");

        com_FakulteEkle.setFont(new java.awt.Font("Agency FB", 3, 18)); // NOI18N
        com_FakulteEkle.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Teknoloji", "Mühendislik" }));

        com_BolumEkle.setFont(new java.awt.Font("Agency FB", 3, 18)); // NOI18N
        com_BolumEkle.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Yazılım", "Elektrik", "Otomotiv", "İnşaat" }));

        com_MufredatEkle.setFont(new java.awt.Font("Agency FB", 3, 18)); // NOI18N
        com_MufredatEkle.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Gündüz", "Gece" }));

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
        jScrollPane1.setViewportView(table_Ekle);

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ogrenciotomasyonu/Windows-Close-Program-icon.png"))); // NOI18N
        jButton7.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/ogrenciotomasyonu/close.jpg"))); // NOI18N
        jButton7.setDisabledSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/ogrenciotomasyonu/close.jpg"))); // NOI18N
        jButton7.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton7.setMargin(new java.awt.Insets(1, 1, 1, 1));
        jButton7.setMaximumSize(new java.awt.Dimension(100, 100));
        jButton7.setMinimumSize(new java.awt.Dimension(100, 100));
        jButton7.setPreferredSize(new java.awt.Dimension(100, 100));
        jButton7.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/ogrenciotomasyonu/close.jpg"))); // NOI18N
        jButton7.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_KayitEkleLayout = new javax.swing.GroupLayout(panel_KayitEkle);
        panel_KayitEkle.setLayout(panel_KayitEkleLayout);
        panel_KayitEkleLayout.setHorizontalGroup(
            panel_KayitEkleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_KayitEkleLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_KayitEkleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panel_KayitEkleLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_KayitEkleLayout.createSequentialGroup()
                        .addGroup(panel_KayitEkleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel_KayitEkleLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btn_Ekle, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(108, 108, 108))
                            .addGroup(panel_KayitEkleLayout.createSequentialGroup()
                                .addGroup(panel_KayitEkleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7))
                                .addGap(25, 25, 25)
                                .addGroup(panel_KayitEkleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txt_TelEkle, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(com_FakulteEkle, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(com_BolumEkle, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(com_MufredatEkle, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txt_TcEkle, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_AdEkle)
                                    .addComponent(txt_DogumEkle))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 567, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(80, 80, 80))
        );
        panel_KayitEkleLayout.setVerticalGroup(
            panel_KayitEkleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_KayitEkleLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(panel_KayitEkleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_TcEkle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panel_KayitEkleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txt_AdEkle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(panel_KayitEkleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_DogumEkle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(panel_KayitEkleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(txt_TelEkle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(panel_KayitEkleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(com_FakulteEkle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(panel_KayitEkleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(com_BolumEkle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(panel_KayitEkleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(com_MufredatEkle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btn_Ekle, javax.swing.GroupLayout.PREFERRED_SIZE, 81, Short.MAX_VALUE))
            .addGroup(panel_KayitEkleLayout.createSequentialGroup()
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Kayıt EKleme", panel_KayitEkle);

        jPanel2.setBackground(new java.awt.Color(250, 233, 250));

        panel_Guncelle.setBackground(new java.awt.Color(250, 233, 250));

        jLabel8.setFont(new java.awt.Font("Snap ITC", 3, 14)); // NOI18N
        jLabel8.setText("T.C.");

        jLabel9.setFont(new java.awt.Font("Snap ITC", 3, 14)); // NOI18N
        jLabel9.setText("Adı Soyadı:");

        jLabel10.setFont(new java.awt.Font("Snap ITC", 3, 14)); // NOI18N
        jLabel10.setText("Doğum Tarihi:");

        jLabel11.setFont(new java.awt.Font("Snap ITC", 3, 14)); // NOI18N
        jLabel11.setText("Telefon:");

        jLabel12.setFont(new java.awt.Font("Snap ITC", 3, 14)); // NOI18N
        jLabel12.setText("Fakülte:");

        jLabel13.setFont(new java.awt.Font("Snap ITC", 3, 14)); // NOI18N
        jLabel13.setText("Bölüm:");

        jLabel14.setFont(new java.awt.Font("Snap ITC", 3, 14)); // NOI18N
        jLabel14.setText("Müfredat:");

        com_FakulteGuncelle.setFont(new java.awt.Font("Agency FB", 3, 18)); // NOI18N
        com_FakulteGuncelle.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Teknoloji", "Mühendislik" }));

        com_BolumGuncelle.setFont(new java.awt.Font("Agency FB", 3, 18)); // NOI18N
        com_BolumGuncelle.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Yazılım", "Elektrik", "Otomotiv", "İnşaat" }));

        com_MufredatGuncelle.setFont(new java.awt.Font("Agency FB", 3, 18)); // NOI18N
        com_MufredatGuncelle.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Gündüz", "Gece" }));

        btn_Guncelle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ogrenciotomasyonu/Edit-Document-icon.png"))); // NOI18N
        btn_Guncelle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_GuncelleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_GuncelleLayout = new javax.swing.GroupLayout(panel_Guncelle);
        panel_Guncelle.setLayout(panel_GuncelleLayout);
        panel_GuncelleLayout.setHorizontalGroup(
            panel_GuncelleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_GuncelleLayout.createSequentialGroup()
                .addGroup(panel_GuncelleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14))
                .addGap(19, 19, 19)
                .addGroup(panel_GuncelleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(com_BolumGuncelle, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(com_MufredatGuncelle, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_DogumGuncelle, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_TelGuncelle)
                    .addComponent(com_FakulteGuncelle, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_GuncelleLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btn_Guncelle, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(87, 87, 87))
            .addGroup(panel_GuncelleLayout.createSequentialGroup()
                .addGroup(panel_GuncelleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8))
                .addGap(38, 38, 38)
                .addGroup(panel_GuncelleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_TcGuncelle)
                    .addComponent(txt_AdiGuncelle))
                .addContainerGap())
        );
        panel_GuncelleLayout.setVerticalGroup(
            panel_GuncelleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_GuncelleLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(panel_GuncelleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_TcGuncelle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(panel_GuncelleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(txt_AdiGuncelle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(panel_GuncelleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txt_DogumGuncelle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(panel_GuncelleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txt_TelGuncelle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(panel_GuncelleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(com_FakulteGuncelle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(panel_GuncelleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_GuncelleLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel13))
                    .addGroup(panel_GuncelleLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(com_BolumGuncelle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(panel_GuncelleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(com_MufredatGuncelle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addGap(18, 18, 18)
                .addComponent(btn_Guncelle, javax.swing.GroupLayout.PREFERRED_SIZE, 102, Short.MAX_VALUE))
        );

        table_Guncelle.setModel(new javax.swing.table.DefaultTableModel(
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
        table_Guncelle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                table_GuncelleMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(table_Guncelle);

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ogrenciotomasyonu/Windows-Close-Program-icon.png"))); // NOI18N
        jButton6.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/ogrenciotomasyonu/close.jpg"))); // NOI18N
        jButton6.setDisabledSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/ogrenciotomasyonu/close.jpg"))); // NOI18N
        jButton6.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton6.setMargin(new java.awt.Insets(1, 1, 1, 1));
        jButton6.setMaximumSize(new java.awt.Dimension(100, 100));
        jButton6.setMinimumSize(new java.awt.Dimension(100, 100));
        jButton6.setPreferredSize(new java.awt.Dimension(100, 100));
        jButton6.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/ogrenciotomasyonu/close.jpg"))); // NOI18N
        jButton6.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(panel_Guncelle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 585, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(panel_Guncelle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Kayıt Güncelleme", jPanel2);

        panel_Sil.setBackground(new java.awt.Color(229, 228, 246));

        jLabel15.setFont(new java.awt.Font("Snap ITC", 3, 14)); // NOI18N
        jLabel15.setText("T.C.");

        table_Sil.setModel(new javax.swing.table.DefaultTableModel(
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
        table_Sil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                table_SilMousePressed(evt);
            }
        });
        jScrollPane3.setViewportView(table_Sil);

        btn_Sil2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ogrenciotomasyonu/delete-file-icon.png"))); // NOI18N
        btn_Sil2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Sil2ActionPerformed(evt);
            }
        });

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ogrenciotomasyonu/Windows-Close-Program-icon.png"))); // NOI18N
        jButton5.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/ogrenciotomasyonu/close.jpg"))); // NOI18N
        jButton5.setDisabledSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/ogrenciotomasyonu/close.jpg"))); // NOI18N
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton5.setMargin(new java.awt.Insets(1, 1, 1, 1));
        jButton5.setMaximumSize(new java.awt.Dimension(100, 100));
        jButton5.setMinimumSize(new java.awt.Dimension(100, 100));
        jButton5.setPreferredSize(new java.awt.Dimension(100, 100));
        jButton5.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/ogrenciotomasyonu/close.jpg"))); // NOI18N
        jButton5.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_SilLayout = new javax.swing.GroupLayout(panel_Sil);
        panel_Sil.setLayout(panel_SilLayout);
        panel_SilLayout.setHorizontalGroup(
            panel_SilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_SilLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_SilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_SilLayout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(9, 9, 9)
                        .addComponent(txt_KayitSil, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_SilLayout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(btn_Sil2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 638, Short.MAX_VALUE))
            .addGroup(panel_SilLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panel_SilLayout.setVerticalGroup(
            panel_SilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_SilLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(panel_SilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_KayitSil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addGap(30, 30, 30)
                .addComponent(btn_Sil2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(208, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_SilLayout.createSequentialGroup()
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Kayıt Silme", panel_Sil);

        jPanel1.setBackground(new java.awt.Color(250, 247, 209));

        jLabel16.setFont(new java.awt.Font("Snap ITC", 3, 14)); // NOI18N
        jLabel16.setText("Aramak İstediğiniz Öğrencinin T.C. Giriniz");

        btn_Ara.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ogrenciotomasyonu/Search-icon.png"))); // NOI18N
        btn_Ara.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AraActionPerformed(evt);
            }
        });

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
        jScrollPane4.setViewportView(table_Ara);

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel16)
                .addGap(18, 18, 18)
                .addComponent(txt_Ara, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(btn_Ara, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 126, Short.MAX_VALUE)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_Ara, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16)))
                    .addComponent(btn_Ara, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Öğrenci Ara", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 883, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_EkleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_EkleActionPerformed
        
       // int tc = Integer.parseInt(txt_TcEkle.getText());
        String tc=txt_TcEkle.getText();
        String ad=txt_AdEkle.getText();
        String dgm=txt_DogumEkle.getText();
        String tel=txt_TelEkle.getText();
        String fakulte,bolum,mufredat;
        if (com_FakulteEkle.getSelectedIndex()==0) {
            fakulte="Tekonoloji";
        }
        else fakulte="Mühendislik";
        if (com_BolumEkle.getSelectedIndex()==0) {
            bolum="Yazılım";
        }
        else if (com_BolumEkle.getSelectedIndex()==1) {
            bolum="Elektrik";
        }
        else if (com_BolumEkle.getSelectedIndex()==2) {
            bolum="Otomotiv";
        }
        else bolum="İnşaat";
        if (com_MufredatEkle.getSelectedIndex()==0) {
            mufredat="Gündüz";
        }
        else mufredat="Gece";

        try {
            KayitEkle(tc, ad, dgm, tel, fakulte,bolum,mufredat);
             TabloDoldurSil();
            TabloDolduGuncelle();
        } catch (Exception ex) {
            Logger.getLogger(frm_Ogrenciislemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_EkleActionPerformed

    private void btn_GuncelleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_GuncelleActionPerformed
        String eskiNo=table_Guncelle.getValueAt(table_Guncelle.getSelectedRow(),0).toString();
        String tc=txt_TcGuncelle.getText();
        String ad=txt_AdiGuncelle.getText();
        String dgm=txt_DogumGuncelle.getText();
        String tel=txt_TelGuncelle.getText();
        String fakulte,bolum,mufredat;
        if (com_FakulteGuncelle.getSelectedIndex()==0) {
            fakulte="Tekonoloji";
        }
        else fakulte="Mühendislik";
        if (com_BolumGuncelle.getSelectedIndex()==0) {
            bolum="Yazılım";
        }
        else if (com_BolumGuncelle.getSelectedIndex()==1) {
            bolum="Elektrik";
        }
        else if (com_BolumGuncelle.getSelectedIndex()==2) {
            bolum="Otomotiv";
        }
        else bolum="İnşaat";
        if (com_MufredatGuncelle.getSelectedIndex()==0) {
            mufredat="Gündüz";
        }
        else mufredat="Gece";

        try {
            kayitguncelle(tc, ad, dgm, tel, fakulte,bolum,mufredat,eskiNo);
        } catch (Exception ex) {
            Logger.getLogger(frm_Ogrenciislemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_GuncelleActionPerformed

    private void table_GuncelleMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_GuncelleMousePressed
        txt_TcGuncelle.setText(table_Guncelle.getValueAt(table_Guncelle.getSelectedRow(),0).toString());
        txt_AdiGuncelle.setText(table_Guncelle.getValueAt(table_Guncelle.getSelectedRow(),1).toString());
        txt_DogumGuncelle.setText(table_Guncelle.getValueAt(table_Guncelle.getSelectedRow(),2).toString());
        txt_TelGuncelle.setText(table_Guncelle.getValueAt(table_Guncelle.getSelectedRow(),3).toString());

        String fakulte=table_Guncelle.getValueAt(table_Guncelle.getSelectedRow(),4).toString();
        if (fakulte.equals("Teknoloji")) {
            com_FakulteGuncelle.setSelectedIndex(0);
        }
        else com_FakulteGuncelle.setSelectedIndex(1);
        
        String bolum=table_Guncelle.getValueAt(table_Guncelle.getSelectedRow(),5).toString();
        if (bolum.equals("Yazılım")) {
            com_BolumGuncelle.setSelectedIndex(0);
        }
        else if (bolum.equals("Elektrik")) {
            com_BolumGuncelle.setSelectedIndex(1);
        }
        else if (bolum.equals("Otomotiv")) {
            com_BolumGuncelle.setSelectedIndex(2); 
        }
        else com_BolumGuncelle.setSelectedIndex(3); 
        
        String mufredat=table_Guncelle.getValueAt(table_Guncelle.getSelectedRow(),6).toString();
        if (mufredat.equals("Gündüz")) {
            com_MufredatGuncelle.setSelectedIndex(0);
        }
        else com_MufredatGuncelle.setSelectedIndex(1);

        
    }//GEN-LAST:event_table_GuncelleMousePressed

    private void btn_Sil2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Sil2ActionPerformed
       String tc=txt_KayitSil.getText();
        KayitSil(tc);
    }//GEN-LAST:event_btn_Sil2ActionPerformed

    private void table_SilMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_SilMousePressed
        txt_KayitSil.setText(table_Sil.getValueAt(table_Sil.getSelectedRow(),0).toString());
    }//GEN-LAST:event_table_SilMousePressed

    private void btn_AraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AraActionPerformed
       
        String tc=txt_Ara.getText();
        kayitAra(tc);
        
        
    }//GEN-LAST:event_btn_AraActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        System.exit(0);

    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        System.exit(0);

    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        System.exit(0);

    }//GEN-LAST:event_jButton4ActionPerformed

    public static void main(String args[]) {
 
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_Ogrenciislemleri().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Ara;
    private javax.swing.JButton btn_Ekle;
    private javax.swing.JButton btn_Guncelle;
    private javax.swing.JButton btn_Sil2;
    private javax.swing.JComboBox<String> com_BolumEkle;
    private javax.swing.JComboBox<String> com_BolumGuncelle;
    private javax.swing.JComboBox<String> com_FakulteEkle;
    private javax.swing.JComboBox<String> com_FakulteGuncelle;
    private javax.swing.JComboBox<String> com_MufredatEkle;
    private javax.swing.JComboBox<String> com_MufredatGuncelle;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel panel_Guncelle;
    private javax.swing.JPanel panel_KayitEkle;
    private javax.swing.JPanel panel_Sil;
    private javax.swing.JTable table_Ara;
    private javax.swing.JTable table_Ekle;
    private javax.swing.JTable table_Guncelle;
    private javax.swing.JTable table_Sil;
    private javax.swing.JTextField txt_AdEkle;
    private javax.swing.JTextField txt_AdiGuncelle;
    private javax.swing.JTextField txt_Ara;
    private javax.swing.JTextField txt_DogumEkle;
    private javax.swing.JTextField txt_DogumGuncelle;
    private javax.swing.JTextField txt_KayitSil;
    private javax.swing.JTextField txt_TcEkle;
    private javax.swing.JTextField txt_TcGuncelle;
    private javax.swing.JTextField txt_TelEkle;
    private javax.swing.JTextField txt_TelGuncelle;
    // End of variables declaration//GEN-END:variables
}
