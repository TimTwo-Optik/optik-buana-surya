/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package transaksi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import koneksi.koneksi;
import table_model.supplier;

/**
 *
 * @author Bagus
 */
public class RincianDataPembelian extends javax.swing.JFrame {

    private int id_pembelian;
    private int id_barang;
    private int qty;
    
    /**
     * Creates new form RincianDataPembelian
     */
    public RincianDataPembelian() {
        initComponents();
        populateComboBoxes();
    }
    
    public void setData(String no_faktur) {
        
        Connection conn = new koneksi().getConnection();
        
        String sql1 = "select id, tanggal_beli, id_supplier, id_barang, kuantitas, total_harga, status from pembelian where no_faktur = ?";
        String sql2 = "select kategori, jenis_atau_lensa, harga_beli, keterangan from barang where id = ?";
        
        try {
            PreparedStatement stat1 = conn.prepareStatement(sql1);
            stat1.setString(1, no_faktur);
            ResultSet hasil1 = stat1.executeQuery();
            
            hasil1.next();
            id_pembelian = hasil1.getInt(1);
            nofaktur.setText(no_faktur);
            tanggal_beli.setDate(hasil1.getDate(2));
            int id_supplier1 = hasil1.getInt(3);
            int id_barang1 = hasil1.getInt(4);
            id_barang = hasil1.getInt(4);
                
            for (int i = 0; i < cbnamasupplier.getItemCount(); i++) {
                String selectedItem = cbnamasupplier.getItemAt(i);
                int id_supplier2 = Integer.parseInt(selectedItem.split(" ")[0]);
                   
                if (id_supplier1 == id_supplier2) {
                   cbnamasupplier.setSelectedIndex(i);
                }
            }
                
            
            for (int i = 0; i < cbnamaataumerk.getItemCount(); i++) {
                String selectedItem = cbnamaataumerk.getItemAt(i);
                int id_barang2 = Integer.parseInt(selectedItem.split(" ")[0]);
                   
                if (id_barang1 == id_barang2) {
                    cbnamaataumerk.setSelectedIndex(i);
                }
            }
               
            kuantitas.setText(hasil1.getString(5));
            qty = Integer.parseInt(hasil1.getString(5));
            transaksi.setText(hasil1.getString(6));
                
            if(hasil1.getString(7).equals("Lunas")) {
                status.setSelectedIndex(0);
            } else {
                status.setSelectedIndex(1);
            }
            
            
            PreparedStatement stat2 = conn.prepareStatement(sql2);
            stat2.setInt(1, id_barang1);
            ResultSet hasil2 = stat2.executeQuery();
            
            hasil2.next();
            
            switch (hasil2.getString(1)) {
                case "Frame":
                    cbkategori.setSelectedIndex(0);
                    break;
                case "Lensa":
                    cbkategori.setSelectedIndex(1);
                    break;
                case "Lainnya":
                    cbkategori.setSelectedIndex(2);
                    break;
                default:
                    throw new AssertionError();
            }
            
            jenisbarangataulensa.setText(hasil2.getString(2));
            hargaperunit.setText(hasil2.getString(3));
            keterangan.setText(hasil2.getString(4));
            
            conn.close();
            stat1.close();
        }catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "data gagal ditampilkan, pesan error: " + e);
            Logger.getLogger(supplier.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    private void populateComboBoxes() {
        Connection conn = new koneksi().getConnection();
    
        String supplierSql = "SELECT id, nama_supplier FROM suppliers";
        String barangSql = "SELECT id, nama FROM barang";
    
        try {
            // Populate pelanggan ComboBox
            PreparedStatement supplierStat = conn.prepareStatement(supplierSql);
            ResultSet supplierRs = supplierStat.executeQuery();
            while (supplierRs.next()) {
                int id = supplierRs.getInt("id");
                String namaSupplier = supplierRs.getString("nama_supplier");
                cbnamasupplier.addItem(id + " - " + namaSupplier);
            }
        
            // Populate barang ComboBox
            PreparedStatement barangStat = conn.prepareStatement(barangSql);
            ResultSet barangRs = barangStat.executeQuery();
            while (barangRs.next()) {
                int id = barangRs.getInt("id");
                String namaBarang = barangRs.getString("nama");
                cbnamaataumerk.addItem(id + " - " + namaBarang);
            }
            
            cbnamasupplier.setSelectedItem(null);
            cbnamaataumerk.setSelectedItem(null);
            cbkategori.setSelectedItem(null);
        
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace(); // Tambahkan ini untuk melihat detail error di konsol
            JOptionPane.showMessageDialog(null, "Error loading data: " + e.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        roundedPanel1 = new custom_palette.RoundedPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        editButton = new custom_palette.RoundedButton();
        removeButton = new custom_palette.RoundedButton();
        jLabel13 = new javax.swing.JLabel();
        nofaktur = new custom_palette.RoundedTextField();
        jLabel9 = new javax.swing.JLabel();
        tanggal_beli = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        cbnamasupplier = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        cbnamaataumerk = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        cbkategori = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        jenisbarangataulensa = new custom_palette.RoundedTextField();
        jLabel16 = new javax.swing.JLabel();
        hargaperunit = new custom_palette.RoundedTextField();
        jLabel5 = new javax.swing.JLabel();
        kuantitas = new custom_palette.RoundedTextField();
        hitungButton = new custom_palette.RoundedButton();
        jLabel12 = new javax.swing.JLabel();
        transaksi = new custom_palette.RoundedTextField();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        keterangan = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        status = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        cancelButton = new custom_palette.RoundedButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(242, 241, 235));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/logo-pembelian2.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 25, -1, -1));

        jLabel2.setFont(new java.awt.Font("Inter", 1, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(142, 175, 148));
        jLabel2.setText("Manajemen Pembelian");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(116, 34, 290, 40));

        roundedPanel1.setBackground(new java.awt.Color(136, 171, 142));
        roundedPanel1.setForeground(new java.awt.Color(136, 171, 142));
        roundedPanel1.setCornerRadius(30);
        roundedPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Inter", 1, 32)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(238, 231, 218));
        jLabel3.setText("Rincian Data Pembelian");
        roundedPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(485, 10, 420, 80));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/logo-penjualan2.png"))); // NOI18N
        roundedPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(88, 148, -1, -1));

        editButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/logo-write.png"))); // NOI18N
        editButton.setColor(new java.awt.Color(247, 147, 39));
        editButton.setColorClick(new java.awt.Color(197, 117, 31));
        editButton.setColorOver(new java.awt.Color(222, 132, 35));
        editButton.setcornerRadius(15);
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });
        roundedPanel1.add(editButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(744, 590, 83, 41));

        removeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/logo-trash.png"))); // NOI18N
        removeButton.setColor(new java.awt.Color(255, 75, 75));
        removeButton.setColorClick(new java.awt.Color(204, 60, 60));
        removeButton.setColorOver(new java.awt.Color(229, 67, 67));
        removeButton.setcornerRadius(15);
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });
        roundedPanel1.add(removeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 590, 83, 41));

        jLabel13.setFont(new java.awt.Font("Inter", 0, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(238, 231, 218));
        jLabel13.setText("No Faktur");
        roundedPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 100, 160, 20));

        nofaktur.setBackground(new java.awt.Color(238, 231, 218));
        nofaktur.setForeground(new java.awt.Color(0, 0, 0));
        nofaktur.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N
        nofaktur.setLineColor(new java.awt.Color(238, 231, 218));
        roundedPanel1.add(nofaktur, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 100, 232, -1));

        jLabel9.setFont(new java.awt.Font("Inter", 0, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(238, 231, 218));
        jLabel9.setText("Tanggal Beli");
        roundedPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 140, 160, 20));

        tanggal_beli.setBackground(new java.awt.Color(238, 231, 218));
        tanggal_beli.setForeground(new java.awt.Color(0, 0, 0));
        tanggal_beli.setDateFormatString("yyyy-MM-dd");
        tanggal_beli.setFont(new java.awt.Font("Inter", 0, 16)); // NOI18N
        tanggal_beli.setOpaque(false);
        tanggal_beli.setPreferredSize(new java.awt.Dimension(232, 22));
        roundedPanel1.add(tanggal_beli, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 140, -1, -1));

        jLabel10.setFont(new java.awt.Font("Inter", 0, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(238, 231, 218));
        jLabel10.setText("Nama Supplier");
        roundedPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 180, 140, -1));

        cbnamasupplier.setBackground(new java.awt.Color(248, 248, 248));
        cbnamasupplier.setFont(new java.awt.Font("Inter", 0, 16)); // NOI18N
        cbnamasupplier.setForeground(new java.awt.Color(0, 0, 0));
        cbnamasupplier.setOpaque(true);
        cbnamasupplier.setPreferredSize(new java.awt.Dimension(118, 26));
        roundedPanel1.add(cbnamasupplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 180, 230, -1));

        jLabel11.setFont(new java.awt.Font("Inter", 0, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(238, 231, 218));
        jLabel11.setText("Nama/Merk");
        roundedPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 220, 140, -1));

        cbnamaataumerk.setBackground(new java.awt.Color(248, 248, 248));
        cbnamaataumerk.setFont(new java.awt.Font("Inter", 0, 16)); // NOI18N
        cbnamaataumerk.setForeground(new java.awt.Color(0, 0, 0));
        cbnamaataumerk.setOpaque(true);
        cbnamaataumerk.setPreferredSize(new java.awt.Dimension(118, 26));
        cbnamaataumerk.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbnamaataumerkPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        roundedPanel1.add(cbnamaataumerk, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 220, 230, -1));

        jLabel18.setFont(new java.awt.Font("Inter", 0, 16)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(238, 231, 218));
        jLabel18.setText("Kategori");
        roundedPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 260, 140, -1));

        cbkategori.setBackground(new java.awt.Color(248, 248, 248));
        cbkategori.setFont(new java.awt.Font("Inter", 0, 16)); // NOI18N
        cbkategori.setForeground(new java.awt.Color(0, 0, 0));
        cbkategori.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Frame", "Lensa", "Lainnya" }));
        cbkategori.setOpaque(true);
        cbkategori.setPreferredSize(new java.awt.Dimension(118, 26));
        roundedPanel1.add(cbkategori, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 260, 230, -1));

        jLabel14.setFont(new java.awt.Font("Inter", 0, 16)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(238, 231, 218));
        jLabel14.setText("Jenis Barang/");
        roundedPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 300, 140, -1));

        jenisbarangataulensa.setBackground(new java.awt.Color(238, 231, 218));
        jenisbarangataulensa.setForeground(new java.awt.Color(0, 0, 0));
        jenisbarangataulensa.setFont(new java.awt.Font("Inter", 0, 16)); // NOI18N
        jenisbarangataulensa.setLineColor(new java.awt.Color(238, 231, 218));
        roundedPanel1.add(jenisbarangataulensa, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 310, 232, -1));

        jLabel16.setFont(new java.awt.Font("Inter", 0, 16)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(238, 231, 218));
        jLabel16.setText("Harga Per Unit");
        roundedPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 360, 130, -1));

        hargaperunit.setBackground(new java.awt.Color(238, 231, 218));
        hargaperunit.setForeground(new java.awt.Color(0, 0, 0));
        hargaperunit.setFont(new java.awt.Font("Inter", 0, 16)); // NOI18N
        hargaperunit.setLineColor(new java.awt.Color(238, 231, 218));
        roundedPanel1.add(hargaperunit, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 360, 232, -1));

        jLabel5.setFont(new java.awt.Font("Inter", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(238, 231, 218));
        jLabel5.setText("Kuantitas");
        roundedPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 400, 140, -1));

        kuantitas.setBackground(new java.awt.Color(238, 231, 218));
        kuantitas.setForeground(new java.awt.Color(0, 0, 0));
        kuantitas.setFont(new java.awt.Font("Inter", 0, 16)); // NOI18N
        kuantitas.setLineColor(new java.awt.Color(238, 231, 218));
        roundedPanel1.add(kuantitas, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 400, 150, -1));

        hitungButton.setForeground(new java.awt.Color(136, 171, 142));
        hitungButton.setText("Hitung");
        hitungButton.setColor(new java.awt.Color(238, 231, 218));
        hitungButton.setColorClick(new java.awt.Color(190, 184, 174));
        hitungButton.setColorOver(new java.awt.Color(214, 207, 196));
        hitungButton.setcornerRadius(15);
        hitungButton.setFont(new java.awt.Font("Inter", 1, 14)); // NOI18N
        hitungButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hitungButtonActionPerformed(evt);
            }
        });
        roundedPanel1.add(hitungButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(865, 400, 80, 22));

        jLabel12.setFont(new java.awt.Font("Inter", 0, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(238, 231, 218));
        jLabel12.setText("Total Transaksi");
        roundedPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 440, 130, -1));

        transaksi.setBackground(new java.awt.Color(238, 231, 218));
        transaksi.setForeground(new java.awt.Color(0, 0, 0));
        transaksi.setFont(new java.awt.Font("Inter", 0, 16)); // NOI18N
        transaksi.setLineColor(new java.awt.Color(238, 231, 218));
        roundedPanel1.add(transaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 440, 232, -1));

        jLabel17.setFont(new java.awt.Font("Inter", 0, 16)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(238, 231, 218));
        jLabel17.setText("Keterangan");
        roundedPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 480, 130, -1));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        keterangan.setColumns(20);
        keterangan.setFont(new java.awt.Font("Inter", 0, 16)); // NOI18N
        keterangan.setRows(5);
        jScrollPane1.setViewportView(keterangan);

        roundedPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 480, 232, 47));

        jLabel6.setFont(new java.awt.Font("Inter", 0, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(238, 231, 218));
        jLabel6.setText("Status");
        roundedPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 545, 130, -1));

        status.setBackground(new java.awt.Color(248, 248, 248));
        status.setFont(new java.awt.Font("Inter", 0, 16)); // NOI18N
        status.setForeground(new java.awt.Color(0, 0, 0));
        status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lunas", "Belum Lunas" }));
        status.setOpaque(true);
        status.setPreferredSize(new java.awt.Dimension(118, 26));
        roundedPanel1.add(status, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 545, 230, -1));

        jLabel15.setFont(new java.awt.Font("Inter", 0, 16)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(238, 231, 218));
        jLabel15.setText("Lensa");
        roundedPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 320, 140, -1));

        jPanel1.add(roundedPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(137, 89, 1006, 650));

        cancelButton.setForeground(new java.awt.Color(238, 231, 218));
        cancelButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/material-symbols_batal.png"))); // NOI18N
        cancelButton.setText("Batal");
        cancelButton.setColor(new java.awt.Color(136, 171, 142));
        cancelButton.setColorClick(new java.awt.Color(108, 136, 113));
        cancelButton.setColorOver(new java.awt.Color(122, 153, 127));
        cancelButton.setcornerRadius(15);
        cancelButton.setFont(new java.awt.Font("Inter", 1, 12)); // NOI18N
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        jPanel1.add(cancelButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1118, 764, 130, 49));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 832));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        try {
            // Mengatur look and feel menjadi Nimbus
            UIManager.LookAndFeelInfo[] looks = UIManager.getInstalledLookAndFeels();
            for (UIManager.LookAndFeelInfo look : looks) {
                if ("Nimbus".equals(look.getName())) {
                    UIManager.setLookAndFeel(look.getClassName());
                    break;
                }
            }

            // Buat objek JFrame baru
            JFrame formPembelian = new table_model.pembelian();

            // Tampilkan JFrame baru
            formPembelian.setVisible(true);

            // Tutup jendela saat ini
            this.dispose();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        Connection conn = new koneksi().getConnection();
        
        String selectedSupplier = cbnamasupplier.getSelectedItem().toString();
        int id_supplier = Integer.parseInt(selectedSupplier.split(" ")[0]);
        
        String selectedBarang = cbnamaataumerk.getSelectedItem().toString();
        int id_barang1 = Integer.parseInt(selectedBarang.split(" ")[0]);

        try {
            String sql1 = "update pembelian set no_faktur=?, tanggal_beli=?, id_supplier=?, " 
                            + "id_barang=?, jenis_barang_atau_lensa=?, kuantitas=?, "
                            + "total_harga=?, status=? where id=?";
            PreparedStatement stat1 = conn.prepareStatement(sql1);
            stat1.setString(1, nofaktur.getText());
            stat1.setDate(2, new java.sql.Date(tanggal_beli.getDate().getTime()));
            stat1.setInt(3, id_supplier);
            stat1.setInt(4, id_barang1);
            stat1.setString(5, jenisbarangataulensa.getText());
            stat1.setInt(6, Integer.parseInt(kuantitas.getText()));
            stat1.setInt(7, Integer.parseInt(transaksi.getText()));
            stat1.setString(8, status.getSelectedItem().toString());
            stat1.setInt(9, id_pembelian);
            stat1.executeUpdate();
            
            String sql2 = "";
            String sql3 = "";
            
            if (id_barang == id_barang1){
                sql2 = "update barang set stok = stok - ? + ? where id = ?";
                
                PreparedStatement stat2 = conn.prepareStatement(sql2);
                stat2.setInt(1, qty);
                stat2.setInt(2, Integer.parseInt(kuantitas.getText()));
                stat2.setInt(3, id_barang);
                stat2.executeUpdate();
            } else {
                sql2 = "update barang set stok = stok - ? where id = ?";
                sql3 = "update barang set stok = stok + ? where id = ?";
                
                PreparedStatement stat2 = conn.prepareStatement(sql2);
                stat2.setInt(1, qty);
                stat2.setInt(2, id_barang);
                stat2.executeUpdate();
                
                PreparedStatement stat3 = conn.prepareStatement(sql3);
                stat3.setInt(1, qty);
                stat3.setInt(2, id_barang1);
                stat3.executeUpdate();
            }
            
            
            JOptionPane.showMessageDialog(null, "data berhasil diubah");

            conn.close();
            stat1.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "data gagal diubah, pesan error: " + e);
        }
    }//GEN-LAST:event_editButtonActionPerformed

    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
        Connection conn = new koneksi().getConnection();
        
        String selectedBarang = cbnamaataumerk.getSelectedItem().toString();
        int id_barang = Integer.parseInt(selectedBarang.split(" ")[0]);

        int ok = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin menghapus data pembelian ini?", "Hapus Data Karyawan", JOptionPane.YES_NO_OPTION);
        if (ok == 0) {
            String sql1 = "update barang set stok = stok - ? where id = ?";
            String sql2 = "delete from pembelian where id = ?";

            try {
                PreparedStatement stat1 = conn.prepareStatement(sql1);
                stat1.setInt(1, qty);
                stat1.setInt(2, id_barang);
                stat1.executeUpdate();
                
                PreparedStatement stat2 = conn.prepareStatement(sql2);
                stat2.setInt(1, id_pembelian);
                stat2.executeUpdate();
                
                JOptionPane.showMessageDialog(null, "data berhasil dihapus");

                conn.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "data gagal dihapus, pesan error: " + e);
            }

            try {
                // Mengatur look and feel menjadi Nimbus
                UIManager.LookAndFeelInfo[] looks = UIManager.getInstalledLookAndFeels();
                for (UIManager.LookAndFeelInfo look : looks) {
                    if ("Nimbus".equals(look.getName())) {
                        UIManager.setLookAndFeel(look.getClassName());
                        break;
                    }
                }

                // Buat objek JFrame baru
                JFrame pembelian = new table_model.pembelian();

                // Tampilkan JFrame baru
                pembelian.setVisible(true);

                // Tutup jendela saat ini
                this.dispose();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_removeButtonActionPerformed

    private void hitungButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hitungButtonActionPerformed
        int harga = Integer.parseInt(hargaperunit.getText());
        int qty = Integer.parseInt(kuantitas.getText());
        String total_transaksi = String.valueOf(harga * qty);
        transaksi.setText(total_transaksi);
    }//GEN-LAST:event_hitungButtonActionPerformed

    private void cbnamaataumerkPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbnamaataumerkPopupMenuWillBecomeInvisible
        String selectedItem = cbnamaataumerk.getSelectedItem().toString();
        String id_barang = selectedItem.split(" ")[0];
        
        Connection conn = new koneksi().getConnection();
        String sql = "SELECT kategori, jenis_atau_lensa, harga_beli, keterangan FROM barang WHERE id = ?";
    
        try {
            PreparedStatement supplierStat = conn.prepareStatement(sql);
            supplierStat.setString(1, id_barang);
            ResultSet hasil = supplierStat.executeQuery();
            hasil.next();
            
            switch (hasil.getString(1)) {
                case "Frame":
                    cbkategori.setSelectedIndex(0);
                    break;
                case "Lensa":
                    cbkategori.setSelectedIndex(1);
                    break;
                case "Lainnya":
                    cbkategori.setSelectedIndex(2);
                    break;
                default:
                    throw new AssertionError();
            }
            jenisbarangataulensa.setText(hasil.getString(2));
            hargaperunit.setText(hasil.getString(3));
            keterangan.setText(hasil.getString(4));
            
            supplierStat.close();
            hasil.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace(); // Tambahkan ini untuk melihat detail error di konsol
            JOptionPane.showMessageDialog(null, "Error loading data: " + e.getMessage());
        }
    }//GEN-LAST:event_cbnamaataumerkPopupMenuWillBecomeInvisible

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RincianDataPembelian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RincianDataPembelian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RincianDataPembelian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RincianDataPembelian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RincianDataPembelian().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private custom_palette.RoundedButton cancelButton;
    private javax.swing.JComboBox<String> cbkategori;
    private javax.swing.JComboBox<String> cbnamaataumerk;
    private javax.swing.JComboBox<String> cbnamasupplier;
    private custom_palette.RoundedButton editButton;
    private custom_palette.RoundedTextField hargaperunit;
    private custom_palette.RoundedButton hitungButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private custom_palette.RoundedTextField jenisbarangataulensa;
    private javax.swing.JTextArea keterangan;
    private custom_palette.RoundedTextField kuantitas;
    private custom_palette.RoundedTextField nofaktur;
    private custom_palette.RoundedButton removeButton;
    private custom_palette.RoundedPanel roundedPanel1;
    private javax.swing.JComboBox<String> status;
    private com.toedter.calendar.JDateChooser tanggal_beli;
    private custom_palette.RoundedTextField transaksi;
    // End of variables declaration//GEN-END:variables
}
