import java.awt.*;
import javax.swing.*;

public class Beco {
    public static void main(String[] args) {

        // --- 1. تعريف الفريمات ---
        JFrame b = new JFrame("Adopter Organization");
        JFrame k = new JFrame("Adopter Organization 2"); // شاشة كوكي
        JFrame e = new JFrame("Happy Ending"); // شاشة النهاية

        Font f1 = new Font("Arial", Font.BOLD, 20);
        Color blue = new Color(70, 130, 180);
        Color gray = new Color(128, 128, 128);

        // --- 2. تجهيز الصور والنصوص ---
        String path = "C:\\test\\beco .jpg"; 
        ImageIcon iconBeco = new ImageIcon(path);
        // تصغير الصورة
        if (iconBeco.getIconWidth() > 0) {
            Image img = iconBeco.getImage();
            Image newImg = img.getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH); 
            iconBeco = new ImageIcon(newImg);
        }

        String path2 = "C:\\test\\koke.jpg"; 
        ImageIcon iconKoke = new ImageIcon(path2);
        // تصغير الصورة
        if (iconKoke.getIconWidth() > 0) {
            Image img = iconKoke.getImage();
            Image newImg = img.getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH); 
            iconKoke = new ImageIcon(newImg);
        }

        JLabel imageLabelBeco = new JLabel(iconBeco);
        imageLabelBeco.setAlignmentX(Component.CENTER_ALIGNMENT); 

        JLabel imageLabelKoke = new JLabel(iconKoke);
        imageLabelKoke.setAlignmentX(Component.CENTER_ALIGNMENT); 

        JLabel labelB = new JLabel("You Received Beco !!", SwingConstants.CENTER);
        labelB.setFont(f1);
        labelB.setForeground(blue);
        labelB.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        JLabel labelK = new JLabel("what about my daughter koke ...", SwingConstants.CENTER);
        labelK.setFont(f1);
        labelK.setForeground(gray);
        labelK.setAlignmentX(Component.CENTER_ALIGNMENT);

        // --- 3. أزرار الشاشة الأولى (Beco) ---
        JButton y1 = new JButton("Adopt it .");
        JButton n1 = new JButton("No thx ...");

        // برمجة أزرار الشاشة الأولى
        y1.addActionListener(a -> {
            b.setVisible(false); // نخفي الأولى
            k.setVisible(true);  // نظهر الثانية (كوكي)
        });

        n1.addActionListener(a -> {
            b.setVisible(false);
            e.setVisible(true);  // نظهر النهاية
        });

        JPanel btuns1 = new JPanel(new FlowLayout());
        btuns1.add(y1);
        btuns1.add(n1);
        btuns1.setMaximumSize(new Dimension(500, 50));

        // --- 4. أزرار الشاشة الثانية (Koke) ---
        // لازم نسوي أزرار جديدة عشان ما تنسرق من الشاشة الأولى
        JButton y2 = new JButton("Adopt her too!");
        JButton n2 = new JButton("Just Beco is enough");

        y2.addActionListener(a -> {
            k.setVisible(false);
            e.setVisible(true); // النهاية السعيدة
        });
        
        n2.addActionListener(a -> {
            k.setVisible(false);
            e.setVisible(true);
        });

        JPanel btuns2 = new JPanel(new FlowLayout());
        btuns2.add(y2);
        btuns2.add(n2);
        btuns2.setMaximumSize(new Dimension(500, 50));

        // --- 5. تركيب الشاشة الأولى (Panel 1) ---
        JPanel panel1 = new JPanel(); 
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS)); 
        panel1.add(Box.createVerticalGlue()); 
        panel1.add(labelB);
        panel1.add(Box.createRigidArea(new Dimension(0, 20)));
        panel1.add(imageLabelBeco); // الصورة (شيلي الكومنت لو تبينها)
        panel1.add(Box.createRigidArea(new Dimension(0, 20)));
        panel1.add(btuns1); // نضيف أزرار المجموعة الأولى
        panel1.add(Box.createVerticalGlue());

        // --- 6. تركيب الشاشة الثانية (Panel 2) ---
        JPanel panel2 = new JPanel(); 
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
        panel2.add(Box.createVerticalGlue()); 
        panel2.add(labelK);
        panel2.add(Box.createRigidArea(new Dimension(0, 20)));
        panel2.add(imageLabelKoke);
        panel2.add(Box.createRigidArea(new Dimension(0, 20)));
        panel2.add(btuns2); // نضيف أزرار المجموعة الثانية (الجديدة)
        panel2.add(Box.createVerticalGlue());

        // --- 7. إعدادات الفريمات ---
        
        // إعدادات b
        b.setSize(500, 400);
        b.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        b.add(panel1);
        b.setLocationRelativeTo(null);
        b.setVisible(true); // نبدأ بإظهار هذا فقط

        // إعدادات k
        k.setSize(500, 400);
        k.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        k.add(panel2); 
        k.setLocationRelativeTo(null);
        k.setVisible(false);

        // إعدادات e
        e.setSize(400, 400);
        e.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel endMsg = new JLabel("Thank you for your time !", SwingConstants.CENTER);
        e.add(endMsg);
        e.setLocationRelativeTo(null);
        e.setVisible(false);
    }
}