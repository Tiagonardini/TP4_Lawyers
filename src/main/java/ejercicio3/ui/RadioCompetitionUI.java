package ejercicio3.ui;

import ejercicio3.model.Concursos;
import ejercicio3.model.DefaultConcurso;
import ejercicio3.model.InscriptoValidacion;
import ejercicio3.model.RegistroConcurso;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class RadioCompetitionUI {

    private Concursos concursos;
    private JPanel contentPane;
    private JLabel lblName;
    private JTextField txtName;
    private JLabel lblLastName;
    private JTextField txtLastName;
    private JLabel lblId;
    private JTextField txtId;
    private JLabel lblPhone;
    private JTextField txtPhone;
    private JLabel lblEmail;
    private JTextField txtEmail;
    private JComboBox<String> comboBox;
    private JButton btnOk;
    private JLabel lblCompetition;

    public RadioCompetitionUI(Concursos concursos){
        this.concursos = concursos;
        inicializar();
    }

    private void inicializar(){
        var frame = new JFrame("Inscription to Competition");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, 451, 229);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        frame.setContentPane(contentPane);
        formElements();
        layout();
        frame.setVisible(true);
    }

    private void formElements() {
        lblName = new JLabel("Nombre:");
        txtName = new JTextField();
        txtName.setColumns(10);
        lblLastName = new JLabel("Apellido:");
        txtLastName = new JTextField();
        txtLastName.setColumns(10);
        lblId = new JLabel("Dni:");
        txtId = new JTextField();
        txtId.setColumns(10);
        lblPhone = new JLabel("Telefono:");
        txtPhone = new JTextField();
        txtPhone.setColumns(10);
        lblEmail = new JLabel("Email:");
        txtEmail = new JTextField();
        txtEmail.setColumns(10);
        lblCompetition = new JLabel("Concurso:");
        comboBox = new JComboBox<String>();
        cargarConcursosAlComboBox() ;
        btnOk = new JButton("Ok");
        btnOk.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnOk.setEnabled(true);
                concursos.guardarInscripto(comboBox.getSelectedIndex()+1, txtName.getText(), txtLastName.getText(), txtId.getText(), txtPhone.getText(), txtEmail.getText() );
                btnOk.setEnabled(false);
            }
        });
        lblCompetition = new JLabel("Concurso:");
        comboBox = new JComboBox<String>();
        cargarConcursosAlComboBox() ;

    }



    private void layout() {
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        contentPane.setLayout(gl_contentPane);
        gl_contentPane.setHorizontalGroup(gl_contentPane
                .createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
                        .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(gl_contentPane.createSequentialGroup()
                                        .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addComponent(lblLastName).addComponent(lblId)
                                                .addComponent(lblPhone).addComponent(lblEmail)
                                                .addComponent(lblName).addComponent(lblCompetition))
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                                        .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                .addComponent(comboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(txtEmail, GroupLayout.Alignment.TRAILING)
                                                .addComponent(txtPhone, GroupLayout.Alignment.TRAILING)
                                                .addComponent(txtId, GroupLayout.Alignment.TRAILING)
                                                .addComponent(txtLastName, GroupLayout.Alignment.TRAILING)
                                                .addComponent(txtName, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)))
                                .addComponent(btnOk, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE))
                        .addContainerGap()));
        gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(gl_contentPane.createSequentialGroup()
                        .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(txtName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblName))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(lblLastName).addComponent(txtLastName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(lblId).addComponent(txtId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(gl_contentPane.createSequentialGroup().addComponent(lblPhone)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(lblEmail))
                                .addGroup(gl_contentPane.createSequentialGroup()
                                        .addComponent(txtPhone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(lblCompetition))))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(btnOk)
                        .addContainerGap(67, Short.MAX_VALUE)));
    }

    public void cargarConcursosAlComboBox() {
        List<DefaultConcurso> concursos1 = concursos..recuperarConcursos();

        // Verificar si la lista de concursos no es nula
        if (concursos != null) {
            // Limpiar el combo box antes de agregar elementos
            comboBox.removeAllItems();

            // Recorrer la lista de concursos y agregarlos al combo box si están habilitados
            for (DefaultConcurso concurso : concursos) {
                System.err.println("aca entre 1");
                if (registroConcurso.habilitado(concurso)) {
                    comboBox.addItem(concurso.nombre());
                }
            }

            // Actualizar la interfaz gráfica después de agregar elementos
            comboBox.revalidate();
            comboBox.repaint();
        } else {
            // Manejar el caso en el que la lista de concursos sea nula
            // Por ejemplo, mostrar un mensaje de error o realizar alguna acción adecuada
            System.err.println("La lista de concursos es nula.");
        }
    }
}
