import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerUI {

    public UserModel user = null;

    public JFrame view;

    public JButton btnMakePurchase = new JButton("Make a Purchase");
   // public JButton btnCancelPurchase = new JButton("Cancel a Purchase");
    public JButton btnViewPurchases = new JButton("View Purchase History");
    public JButton btnSearchProduct = new JButton("Search Product");
    public JButton btnManageProfile= new JButton("Update Profile");


    public CustomerUI(UserModel user) {

        this.user = user;

        this.view = new JFrame();

        view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        view.setTitle("Store Management System - Customer View");
        view.setSize(1000, 600);
        view.getContentPane().setLayout(new BoxLayout(view.getContentPane(), BoxLayout.PAGE_AXIS));

        JLabel title = new JLabel("Store Management System");

        title.setFont (title.getFont ().deriveFont (24.0f));
        view.getContentPane().add(title);

        JPanel panelUser = new JPanel(new FlowLayout());
        panelUser.add(new JLabel("Fullname: " + user.mFullname));
        panelUser.add(new JLabel("CustomerID: " + user.mCustomerID));

        view.getContentPane().add(panelUser);

        JPanel panelButtons = new JPanel(new FlowLayout());
        panelButtons.add(btnMakePurchase);
        panelButtons.add(btnViewPurchases);
     //   panelButtons.add(btnCancelPurchase);
        panelButtons.add(btnSearchProduct);
        panelButtons.add(btnManageProfile);

        view.getContentPane().add(panelButtons);


        btnViewPurchases.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                UserModel u = new UserModel();
                PurchaseHistoryUI ui = new PurchaseHistoryUI(u);
                ui.view.setVisible(true);
            }
        });

        btnMakePurchase.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                AddPurchaseUI ap = new AddPurchaseUI();
                ap.run();
            }
        });

        btnSearchProduct.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //UserModel u = this.user;
                ProductSearchUI ui = new ProductSearchUI();
                ui.view.setVisible(true);
            }
        } );


        btnSearchProduct.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //UserModel u = this.user;
                ProductSearchUI ui = new ProductSearchUI();

                ui.view.setVisible(true);
                ui.run();
            }
        } );
        btnManageProfile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //UserModel u = this.user;
                UserModel u = new UserModel();
                ManageProfileUI mp = new ManageProfileUI(u);
                mp.view.setVisible(true);
            }
        } );

    }
}