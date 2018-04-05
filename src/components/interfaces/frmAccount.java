/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components.interfaces;

import components.applications.application;
import components.entity.Account;
import components.models.displayvalueModel;
import components.services.AccountService;
import components.utils.DigitsDocument;
import components.utils.MD5Library;
import components.utils.StringHelpers;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MitsuyoRai
 */
public class frmAccount extends javax.swing.JPanel {
    protected AccountService accountService;
    List<Account> listAll;
    DefaultTableModel tableModel;
    /**
     * Creates new form frmAccount
     */
    public frmAccount() {
        initComponents();
        onLoad();
        getHeaderTable();
        getDataAccount();
        getDataStatusType();
        txtNumPhone.setDocument(new DigitsDocument());
    }
    
    private void onLoad(){
        accountService = new AccountService();
        listAll = accountService.getList();
    }
    
    private void setSelectedCombobox(String cbbselected, JComboBox cbb) {
        for (int i = 0; i < cbb.getItemCount(); i++) {
            Object obj = cbb.getItemAt(i);
            if (obj != null) {
                displayvalueModel m = (displayvalueModel) obj;
                if (cbbselected.trim().equals(m.getDisplayMember())) {
                    cbb.setSelectedItem(m);
                }
            }
        }
    }
    
    private void getHeaderTable(){
        Object[] obj = new Object[]{"ID" ,"Username", "Firstname", "Lastname",  "Họ tên", "Số điện thoại", "Email", "Status","Trạng thái", "Role", "Quyền hạn", "Password"};
        tableModel = new DefaultTableModel(obj, 0);
        jTableAccount.setModel(tableModel);
    }
    
    private void getDataAccount(){
        int c = 0;
        try {
            listAll.forEach(account->{
                Object[] item = new Object[12];
                item[0] = account.getAccountId();
                item[1] = account.getUsername();
                item[2] = account.getFirstName();
                item[3] = account.getLastName();
                item[4] = account.getLastName() + " " + account.getFirstName();
                item[5] = account.getNumPhone();
                item[6] = account.getEmail();
                item[7] = account.isInActive();
                item[8] = ( account.isInActive() == true ) ? "Kích hoạt" : "Khóa";
                item[9] = account.getRole();
                item[10] = (account.getAccountId() == 1) ? "Super Admin" : (account.getRole() == 1) ? "Quản lý" : "Nhân viên kho";
                item[11] = account.getPassword();
                tableModel.addRow(item);
            });
            
//            Iterator iter = listCategory.iterator();
//            while (iter.hasNext()) {
//                Category category = (Category) iter.next();
//                Object[] item = new Object[10];
//                item[0] = category.getCategoryId();
//                item[1] = ++c;
//                item[2] = category.getName();
//                tableModel.addRow(item);
//            }
            //Ẩn ID
            jTableAccount.getColumnModel().getColumn(0).setMinWidth(0);
            jTableAccount.getColumnModel().getColumn(0).setMaxWidth(0);
            
            jTableAccount.getColumnModel().getColumn(2).setMinWidth(0);
            jTableAccount.getColumnModel().getColumn(2).setMaxWidth(0);
            
            jTableAccount.getColumnModel().getColumn(3).setMinWidth(0);
            jTableAccount.getColumnModel().getColumn(3).setMaxWidth(0);
            
            jTableAccount.getColumnModel().getColumn(7).setMinWidth(0);
            jTableAccount.getColumnModel().getColumn(7).setMaxWidth(0);
            
            jTableAccount.getColumnModel().getColumn(9).setMinWidth(0);
            jTableAccount.getColumnModel().getColumn(9).setMaxWidth(0);
            
            jTableAccount.getColumnModel().getColumn(11).setMinWidth(0);
            jTableAccount.getColumnModel().getColumn(11).setMaxWidth(0);
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }
    
    private void getDataStatusType() {
        DefaultComboBoxModel cbbmodel = new DefaultComboBoxModel();
        displayvalueModel valueModel1 = new displayvalueModel("Kích hoạt", 1);
        cbbmodel.addElement(valueModel1);
        displayvalueModel valueModel2 = new displayvalueModel("Khóa", 2);
        cbbmodel.addElement(valueModel2);
        cboStatus.setModel(cbbmodel);
        
        DefaultComboBoxModel cbbmodel2 = new DefaultComboBoxModel();
        displayvalueModel valueModel3 = new displayvalueModel("Quản lý", 1);
        cbbmodel2.addElement(valueModel3);
        displayvalueModel valueModel4 = new displayvalueModel("Nhân viên kho", 0);
        cbbmodel2.addElement(valueModel4);
        cboRole.setModel(cbbmodel2);
    }
    
    private void resetInputAccount(){
        txtUsername.setText("");
        txtPassword.setText("");
        txtFirstname.setText("");
        txtLastname.setText("");
        txtNumPhone.setText("");
        txtEmail.setText("");
        this._accountId = -1;
        this._role = 0;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelAccountList = new javax.swing.JPanel();
        jLabelTitle = new javax.swing.JLabel();
        jScrollPaneAccount = new javax.swing.JScrollPane();
        jTableAccount = new javax.swing.JTable();
        jPanelPagingAccount = new javax.swing.JPanel();
        jPanelAccountAction = new javax.swing.JPanel();
        jLabelAction = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        txtLastname = new javax.swing.JTextField();
        txtFirstname = new javax.swing.JTextField();
        txtNumPhone = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        cboStatus = new javax.swing.JComboBox<>();
        cboRole = new javax.swing.JComboBox<>();
        btnInsert = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(900, 611));
        setPreferredSize(new java.awt.Dimension(920, 611));

        jLabelTitle.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelTitle.setText("Danh Sách Tài khoản");

        jTableAccount.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Username", "Họ tên", "Số điện thoại", "Email", "Trạng thái", "Quyền hạn"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTableAccount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableAccountMouseClicked(evt);
            }
        });
        jScrollPaneAccount.setViewportView(jTableAccount);

        javax.swing.GroupLayout jPanelPagingAccountLayout = new javax.swing.GroupLayout(jPanelPagingAccount);
        jPanelPagingAccount.setLayout(jPanelPagingAccountLayout);
        jPanelPagingAccountLayout.setHorizontalGroup(
            jPanelPagingAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanelPagingAccountLayout.setVerticalGroup(
            jPanelPagingAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 57, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanelAccountListLayout = new javax.swing.GroupLayout(jPanelAccountList);
        jPanelAccountList.setLayout(jPanelAccountListLayout);
        jPanelAccountListLayout.setHorizontalGroup(
            jPanelAccountListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAccountListLayout.createSequentialGroup()
                .addGap(245, 245, 245)
                .addComponent(jLabelTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                .addGap(209, 209, 209))
            .addComponent(jScrollPaneAccount)
            .addComponent(jPanelPagingAccount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelAccountListLayout.setVerticalGroup(
            jPanelAccountListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAccountListLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPaneAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 509, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelPagingAccount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabelAction.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelAction.setText("Thao tác");

        jLabel1.setText("Username:");

        jLabel2.setText("Họ:");

        jLabel3.setText("Tên:");

        jLabel4.setText("Password:");

        jLabel5.setText("SDT:");

        jLabel6.setText("Email:");

        jLabel7.setText("Trạng thái:");

        jLabel8.setText("Quyền hạn:");

        cboStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cboRole.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnInsert.setText("Thêm");
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });

        btnUpdate.setText("Cập nhật");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setText("Xóa");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelAccountActionLayout = new javax.swing.GroupLayout(jPanelAccountAction);
        jPanelAccountAction.setLayout(jPanelAccountActionLayout);
        jPanelAccountActionLayout.setHorizontalGroup(
            jPanelAccountActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAccountActionLayout.createSequentialGroup()
                .addGroup(jPanelAccountActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelAccountActionLayout.createSequentialGroup()
                        .addGroup(jPanelAccountActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelAccountActionLayout.createSequentialGroup()
                                .addGap(113, 113, 113)
                                .addComponent(jLabelAction))
                            .addGroup(jPanelAccountActionLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2))
                            .addGroup(jPanelAccountActionLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel3))
                            .addGroup(jPanelAccountActionLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel5))
                            .addGroup(jPanelAccountActionLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel6))
                            .addGroup(jPanelAccountActionLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel7)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanelAccountActionLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanelAccountActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelAccountActionLayout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelAccountActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cboStatus, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cboRole, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanelAccountActionLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelAccountActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtFirstname)
                                    .addComponent(txtNumPhone)
                                    .addComponent(txtEmail, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtPassword)
                                    .addComponent(txtLastname)))
                            .addGroup(jPanelAccountActionLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtUsername))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAccountActionLayout.createSequentialGroup()
                                .addGap(0, 1, Short.MAX_VALUE)
                                .addComponent(btnInsert)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelAccountActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanelAccountActionLayout.createSequentialGroup()
                                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnDelete)))))))
                .addContainerGap())
        );
        jPanelAccountActionLayout.setVerticalGroup(
            jPanelAccountActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAccountActionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelAction)
                .addGap(18, 18, 18)
                .addGroup(jPanelAccountActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelAccountActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanelAccountActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtLastname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelAccountActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtFirstname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelAccountActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtNumPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelAccountActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelAccountActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cboStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelAccountActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cboRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelAccountActionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInsert)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnReset)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelAccountList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelAccountAction, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelAccountList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelAccountAction, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
        // TODO add your handling code here:
        String Username, password, firstname, lastname, numphone, email;
        Boolean inactive;
        int role;
        String pw = new String(txtPassword.getPassword());
        if (txtUsername.getText().equals("")) {
            StringHelpers.Message("Vui lòng nhập Username", "Thông báo", 2);
            txtUsername.requestFocus();
            return;
        } else if (accountService.hasUsername(txtUsername.getText().toString())) {
            StringHelpers.Message("Username đã tồn tại", "Thông báo", 2);
            txtUsername.requestFocus();
            return;
        } else if (pw.equals("")) {
            StringHelpers.Message("Vui lòng nhập Mật khẩu", "Thông báo", 2);
            txtPassword.requestFocus();
            return;
        } else if( txtEmail.getText().equals("") == false  ) {
            if(!validate(txtEmail.getText())) {
                StringHelpers.Message("Email không đúng định dạng", "Thông báo", 2);
                txtEmail.requestFocus();
                return;
            } else if(accountService.hasEmail(txtEmail.getText().toString())){
                StringHelpers.Message("Email đã được đăng ký", "Thông báo", 2);
                txtEmail.requestFocus();
                return;
            }
        } else if( txtNumPhone.getText().equals("") == false  ) {
            if(txtNumPhone.getText().length() < 10 || txtNumPhone.getText().length() > 11) {
                StringHelpers.Message("Email không đúng định dạng", "Thông báo", 2);
                txtEmail.requestFocus();
                return;
            }
        }

        Username = txtUsername.getText();
        password = MD5Library.md5(pw);
        firstname = txtFirstname.getText();
        lastname = txtLastname.getText();
        numphone = txtNumPhone.getText();
        email = txtEmail.getText();
        inactive = ( GetCbbSelected(cboStatus) == 1 ) ? true : false;
        role = GetCbbSelected(cboRole);

        Account dto = new Account();
        dto.setAccountId(-1);
        dto.setUsername(Username);
        dto.setPassword(password);
        dto.setFirstName(firstname);
        dto.setLastName(lastname);
        dto.setNumPhone(numphone);
        dto.setEmail(email);
        dto.setInActive(inactive);
        dto.setRole(role);                

        if (accountService.insert(dto)) {
            StringHelpers.Message("Tài khoản đã được thêm vào csdl", "Thành công", 1);
        } else {
            StringHelpers.Message("Vui lòng thử lại", "Thất bại", 2);
        }
        onLoad();

        getHeaderTable();
        getDataAccount();
        resetInputAccount();
        
    }//GEN-LAST:event_btnInsertActionPerformed
    
    private int GetCbbSelected(JComboBox cbb) {
        Object[] obj = cbb.getSelectedObjects();
        displayvalueModel item = (displayvalueModel) obj[0];
        return Integer.parseInt(item.getDisplayvalue().toString());
    }
    
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =  Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public static boolean validate(String emailStr) {
            Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(emailStr);
            return matcher.find();
    }
    
    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        String Username, password, firstname, lastname, numphone, email;
        Boolean inactive;
        int role;
        if( this._accountId == -1 ) {
            StringHelpers.Message("Vui lòng chọn tài khoản cần sửa", "Thông báo", 2);
            return;
        }
        if (txtUsername.getText().equals("")) {
            StringHelpers.Message("Vui lòng nhập Username", "Thông báo", 2);
            txtUsername.requestFocus();
            return;
        } else if (accountService.hasUsername2(txtUsername.getText().toString(), this._accountId)) {
            StringHelpers.Message("Username đã tồn tại", "Thông báo", 2);
            txtUsername.requestFocus();
            return;
        } else if (txtPassword.getPassword().equals("")) {
            StringHelpers.Message("Vui lòng nhập Mật khẩu", "Thông báo", 2);
            txtPassword.requestFocus();
            return;
        } else if( txtEmail.getText().equals("") == false ) {
            if(!validate(txtEmail.getText())) {
                StringHelpers.Message("Email không đúng định dạng", "Thông báo", 2);
                txtEmail.requestFocus();
                return;
            } else if(accountService.hasEmail2(txtEmail.getText().toString(), this._accountId)){
                StringHelpers.Message("Email đã được đăng ký", "Thông báo", 2);
                txtEmail.requestFocus();
                return;
            }
        }

        Username = txtUsername.getText();
        String pw = new String(txtPassword.getPassword());
        password = MD5Library.md5(pw);
        firstname = txtFirstname.getText();
        lastname = txtLastname.getText();
        numphone = txtNumPhone.getText();
        email = txtEmail.getText();
        inactive = ( GetCbbSelected(cboStatus) == 1 ) ? true : false;
        role = GetCbbSelected(cboRole);
        //System.out.println(application.accountId);
        if( application.accountId != 1 && this._accountId == 1) {
            StringHelpers.Message("Bạn không thể chỉnh sửa tài khoản này", "Cảnh báo", 1);
        } else if( application.role == 1 && this._role == 1 && application.accountId != this._accountId ){
            StringHelpers.Message("Bạn không thể chỉnh sửa tài khoản này", "Cảnh báo", 1);
        } else {
            Account dto = new Account();
            dto.setAccountId(this._accountId);
            dto.setUsername(Username);
            if( pw.equals("") == false ){
                dto.setPassword(password);
            } else {
                dto.setPassword(this._oldpass);
            }
            dto.setFirstName(firstname);
            dto.setLastName(lastname);
            dto.setNumPhone(numphone);
            dto.setEmail(email);
            dto.setInActive(inactive);
            dto.setRole(role);
        
            if (accountService.update(dto)) {
                StringHelpers.Message("Tài khoản đã được cập nhật", "Thành công", 1);
            } else {
                StringHelpers.Message("Vui lòng thử lại", "Thất bại", 2);
            }
        }
        
        onLoad();
        getHeaderTable();
        getDataAccount();
        resetInputAccount();
    }//GEN-LAST:event_btnUpdateActionPerformed
    
    private int _accountId = -1;
    private int _role = -1;
    private String _oldpass = "";
    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        //System.out.print(application.role);
        if( _accountId == -1 ){
            StringHelpers.Message("Vui lòng chọn tài khoản cần Xóa", "Thông báo", 2);
            return;
        } else if( _accountId == application.accountId ) {
            StringHelpers.Message("Bạn không thể xóa tài khoản của chính mình", "Thông báo", 2);
            return;
        } else if( application.role < 1 ) {
            StringHelpers.Message("Bạn không đủ quyền hạn", "Thông báo", 2);
            return;
        }  else if( application.accountId != 1 && _role == 1 ) {
            StringHelpers.Message("Bạn không thể xóa người cùng quyền hạn", "Thông báo", 2);
            return;
        }
        int dialogResult = JOptionPane.showConfirmDialog (null, "Bạn chắc chắn muốn xóa tài khoản này?", "Warning", JOptionPane.YES_NO_OPTION);
        if(dialogResult == JOptionPane.YES_OPTION){
            Account dto = new Account();
            dto.setAccountId(this._accountId);
            if (accountService.delete(dto)) {
                StringHelpers.Message("Tài khoản đã được Xóa thành công", "Thành công", 1);
            }

            onLoad();
            getHeaderTable();
            getDataAccount();
            resetInputAccount();
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void jTableAccountMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableAccountMouseClicked
        // TODO add your handling code here:
        int index = jTableAccount.getSelectedRow();
        this._accountId = Integer.valueOf(jTableAccount.getValueAt(index, 0).toString());
        this._role = Integer.valueOf(jTableAccount.getValueAt(index, 9).toString());
        this._oldpass = jTableAccount.getValueAt(index, 11).toString();
        txtUsername.setText(jTableAccount.getValueAt(index, 1).toString());
        txtLastname.setText(jTableAccount.getValueAt(index, 3).toString());
        txtFirstname.setText(jTableAccount.getValueAt(index, 2).toString());
        txtNumPhone.setText(jTableAccount.getValueAt(index, 5).toString());
        txtEmail.setText(jTableAccount.getValueAt(index, 6).toString());
        
        setSelectedCombobox(jTableAccount.getValueAt(index, 8).toString(), cboStatus);
        setSelectedCombobox(jTableAccount.getValueAt(index, 10).toString(), cboRole);
    }//GEN-LAST:event_jTableAccountMouseClicked

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        onLoad();
        getHeaderTable();
        getDataAccount();
        resetInputAccount();
    }//GEN-LAST:event_btnResetActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cboRole;
    private javax.swing.JComboBox<String> cboStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelAction;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JPanel jPanelAccountAction;
    private javax.swing.JPanel jPanelAccountList;
    private javax.swing.JPanel jPanelPagingAccount;
    private javax.swing.JScrollPane jScrollPaneAccount;
    private javax.swing.JTable jTableAccount;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFirstname;
    private javax.swing.JTextField txtLastname;
    private javax.swing.JTextField txtNumPhone;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
