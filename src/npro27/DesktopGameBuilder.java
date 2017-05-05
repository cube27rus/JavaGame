package npro27;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by Cube27 on 05.05.2017.
 */
public class DesktopGameBuilder {
    public static Game build(Dimension screenSize){
        final CanvasGame game = new CanvasGame(screenSize);
        JFrame frame = new JFrame();
        frame.setFocusable(false);//невозможно выбрать в окне
        frame.setResizable(false);//не изменяемый
        frame.setLayout(new BorderLayout());
        frame.add(game);//добавляем игру на фрейм
        frame.pack();//устанавливает минимально необходимый размер окна
        frame.setVisible(true);//непрозрачность
        game.createBufferStrategy(2);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);// завершить по закрытию
        frame.setLocationRelativeTo(null);//расположить по центру
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent event) {
                game.pause();
            }
        });
        frame.requestFocus();//установка фокуса
        game.requestFocus();//установка фокуса
        return game;
    }
}
