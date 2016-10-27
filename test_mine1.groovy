import java.awt.BasicStroke;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.LinearGradientPaint;
import java.awt.Font;
import de.erichseifert.gral.plots.BarPlot.BarRenderer;
import de.erichseifert.gral.data.DataTable;
import de.erichseifert.gral.plots.XYPlot;
import de.erichseifert.gral.plots.lines.DefaultLineRenderer2D;
import de.erichseifert.gral.plots.lines.LineRenderer;
import de.erichseifert.gral.plots.points.PointRenderer;
import de.erichseifert.gral.graphics.Insets2D;
import de.erichseifert.gral.ui.InteractivePanel;
import de.erichseifert.gral.plots.BarPlot;

public class SimpleBarPlot extends JFrame {
  public SimpleBarPlot() {
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setSize(800, 600);

    DataTable data = new DataTable(BigDecimal.class, Integer.class, String.class);
    data.add(0.1,  1, "January");
    data.add(0.2,  3, "February");
    data.add(0.3, -2, "March");
    data.add(0.4,  6, "April");
    data.add(0.5, -4, "May");
    data.add(0.6,  8, "June");
    data.add(0.7,  9, "July");
    data.add(0.8, 11, "August");

    // Create new bar plot
    BarPlot plot = new BarPlot(data);

    // Format plot
    //plot.setInsets(new Insets2D.Double(40.0, 40.0, 40.0, 40.0));
    plot.setBarWidth(0.075);

    // Format bars
    BarRenderer pointRenderer = (BarRenderer) plot.getPointRenderers(data).get(0);
    //pointRenderer.setColor(
    //    new LinearGradientPaint(0f,0f, 0f,1f, [0f,1f],
    //                            [ COLOR1, GraphicsUtils.deriveBrighter(COLOR1) ]
    //      )
    //    );
    pointRenderer.setBorderStroke(new BasicStroke(3f));
    //pointRenderer.setBorderColor(
    //    new LinearGradientPaint(0f,0f, 0f,1f,
    //      [ 0.0f, 1.0f ], [ GraphicsUtils.deriveBrighter(COLOR1), COLOR1 ]
    //      )
    //    );
    pointRenderer.setValueVisible(true);
    pointRenderer.setValueColumn(2);
    //pointRenderer.setValueLocation(Location.CENTER);
    //pointRenderer.setValueColor(GraphicsUtils.deriveDarker(COLOR1));
    pointRenderer.setValueFont(Font.decode(null).deriveFont(Font.BOLD));

    getContentPane().add(new InteractivePanel(plot));
  }

  public static void main(String[] args) {
    SimpleBarPlot frame = new SimpleBarPlot();
    frame.setVisible(true);
  }
}

