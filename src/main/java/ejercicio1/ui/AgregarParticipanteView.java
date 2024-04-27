package ejercicio1.ui;

import ejercicio1.model.Participante;
import ejercicio1.model.RegistroDeParticipantes;

import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
public class AgregarParticipanteView extends JFrame {

    private RegistroDeParticipantes regParticipantes;
    private Participante participante;
    private JTextField nombre;
    private JTextField telefono;
    private JTextField region;
    public AgregarParticipanteView(RegistroDeParticipantes regParticipantes, Participante participante){
        this.regParticipantes = regParticipantes;
        this.participante = participante;
    }

    public void launch() {
        setTitle("Add Participant");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.nombre = new JTextField(10);
        this.telefono = new JTextField(10);
        this.region = new JTextField(10);
        this.nombre.setText("");
        this.telefono.setText("");
        this.region.setText("");
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new FlowLayout());
        contentPane.add(new JLabel("Nombre: "));
        contentPane.add(nombre);
        contentPane.add(new JLabel("Telefono: "));
        contentPane.add(telefono);
        contentPane.add(new JLabel("Region: "));
        contentPane.add(region);
        JButton botonCargar = new JButton("Cargar");
        botonCargar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    onBotonCargar();
                } catch (RuntimeException e1) {
                    throw new RuntimeException(e1);
                }
            }
        });
        contentPane.add(botonCargar);
        setContentPane(contentPane);
        contentPane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        pack();
        setVisible(true);
    }
    private void onBotonCargar(){
        if (nombre.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Debe cargar un nombre");
            return;
        }
        if (telefono.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Debe cargar un telefono");
            return;
        }
        if (!participante.validarTelefono(telefono.getText())) {
            JOptionPane.showMessageDialog(this, "El teléfono debe ingresarse de la siguiente forma: NNNN-NNNNNN");
            return;
        }
        if (!participante.listaRegionesPermitidas(region.getText())) {
            JOptionPane.showMessageDialog(this, "Region desconocida. Las conocidas son: China, US, Europa");
            return;
        }
        regParticipantes.guardarPersonaje(nombre.getText(), region.getText(), telefono.getText());
        dispose();
    }

}