package real_spring.how_to_refresh_prototype_in_singleton;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

import static design_patterns.heroesGame.RandomUtil.getRandomInRange;

@Component
public /*abstract*/ class ColorFrame extends JFrame {
    @Autowired
    private Color color;

    public ColorFrame() {
        setSize(250,250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void moveToRandomLocation(){
        setLocation(getRandomInRange(0,1200),getRandomInRange(0,900));
        /*color = getColorBean();*/
        getContentPane().setBackground(color);
        repaint();
    }

    /*@Lookup
    protected abstract Color getColorBean();*/
}
