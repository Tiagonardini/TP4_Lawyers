package ejercicio0.ui;

import ejercicio0.model.EstacionDeServicio;
import ejercicio0.model.TipoDeCombustible;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class NuevaVentaView {

    private JRadioButton rbReSuper;
    private JRadioButton rbSuper;
    private JTextField litros;
    private EstacionDeServicio estacion;
    private JFrame frame;
    private ButtonGroup bGroup;

    public NuevaVentaView(EstacionDeServicio estacion) {
        this.estacion = estacion;
    }

    protected JComponent createOptionControls() {
        JLabel label1 = new JLabel("Indique lo que desea cargar:");
        bGroup = new ButtonGroup();

        this.rbReSuper = new JRadioButton();
        rbReSuper.setText("ReSuper");
        bGroup.add(rbReSuper);

        this.rbSuper = new JRadioButton();
        rbSuper.setText("Super");
        bGroup.add(rbSuper);

        this.litros = new JTextField();
        this.litros.setText("0");

        Box box = Box.createVerticalBox();
        box.add(label1);
        box.add(Box.createVerticalStrut(5)); // spacer
        box.add(rbReSuper);
        box.add(rbSuper);

        Box box2 = Box.createHorizontalBox();
        JLabel label = new JLabel("Litros");
        box2.add(label);
        box2.add(Box.createHorizontalStrut(5));
        box2.add(litros);
        box.add(box2);

        box.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        return box;
    }

    protected JComponent createButtonPane() {
        JButton button = new JButton("Confirmar compra");
        var self = this;
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    TipoDeCombustible tipo = self.rbReSuper.isSelected()
                            ? TipoDeCombustible.RESUPER
                            : (self.rbSuper.isSelected() ? TipoDeCombustible.SUPER : null);
                    float totalGastado = estacion.nuevaVenta(tipo, Float.parseFloat(self.litros.getText()));
                    JOptionPane.showMessageDialog(frame, "Compra realizada con éxisto, gastaste: " + totalGastado);
                } catch (RuntimeException ex) {
                    JOptionPane.showMessageDialog(frame, ex.getMessage());
                }
            }
        });

        JPanel pane = new JPanel();
        pane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        pane.add(button);

        return pane;
    }

    public void createAndShowUI() {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            JFrame.setDefaultLookAndFeelDecorated(true);
            JDialog.setDefaultLookAndFeelDecorated(true);

            frame = new JFrame("Nueva Venta");
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            Container contentPane = frame.getContentPane();
            contentPane.add(this.createOptionControls(), BorderLayout.CENTER);

            contentPane.add(this.createButtonPane(), BorderLayout.PAGE_END);

            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    class MyFrame extends JFrame implements ActionListener {

        public MyFrame() {
            super("Estación de Servicio");
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);

            JButton button = new JButton("Cerrar");
            button.addActionListener(this);

            Container contentPane = getContentPane();
            contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.PAGE_AXIS));
            contentPane.add(Box.createVerticalGlue()); // takes all extra space
            contentPane.add(button);
            button.setAlignmentX(Component.CENTER_ALIGNMENT); // horizontally centered
            contentPane.add(Box.createVerticalStrut(5)); // spacer
        }

        public void actionPerformed(ActionEvent e) {
            setVisible(false);
            dispose();
        }
    }
}
