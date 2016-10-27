import java.awt.Color
import de.erichseifert.gral.data.DataTable
import de.erichseifert.gral.plots.XYPlot
import de.erichseifert.gral.plots.lines.DefaultLineRenderer2D
import de.erichseifert.gral.plots.lines.LineRenderer
import de.erichseifert.gral.io.plots.DrawableWriterFactory
import de.erichseifert.gral.io.plots.DrawableWriter

public class LinePlotTest {
  public LinePlotTest() {
    DataTable data = new DataTable(Double.class, Double.class);
    for (double x = -5.0; x <= 5.0; x+=0.25) {
      double y = 5.0*Math.sin(x);
      data.add(x, y);
    }
    XYPlot plot = new XYPlot(data);
    LineRenderer lines = new DefaultLineRenderer2D();
    plot.setLineRenderers(data, [lines]);
    Color color = new Color(0.0f, 0.3f, 1.0f);
    plot.getPointRenderers(data)[0].setColor(color);
    plot.getLineRenderers(data)[0].setColor(color);
    DrawableWriter writer = DrawableWriterFactory.getInstance().get("image/png");
    writer.write(plot, new FileOutputStream("test.png"), 600, 400);
  }

  public static void main(String[] args) {
    LinePlotTest frame = new LinePlotTest();
  }
}
