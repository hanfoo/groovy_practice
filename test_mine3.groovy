import java.awt.Color;
import de.erichseifert.gral.data.*
import de.erichseifert.gral.plots.axes.*
import de.erichseifert.gral.plots.*
import de.erichseifert.gral.plots.BarPlot.BarRenderer;
import de.erichseifert.gral.io.plots.*
import de.erichseifert.gral.graphics.*

DataTable data = new DataTable(Integer.class, Integer.class)
data.add(1, 3)
data.add(2, 7)
data.add(3, 13)

BarPlot plot = new BarPlot(data)
plot.getTitle().setText("Hello World")
plot.setBarWidth(0.5)
AxisRenderer xrender = plot.getAxisRenderer(XYPlot.AXIS_X)
AxisRenderer yrender = plot.getAxisRenderer(XYPlot.AXIS_Y)
xrender.setTicksVisible(false)
yrender.setTickSpacing(1)
yrender.setMinorTicksVisible(false)
BarRenderer render = (BarRenderer) plot.getPointRenderers(data).get(0)
render.setValueVisible(true)
render.setColor(Color.BLUE)

DrawableWriter w = DrawableWriterFactory.getInstance().get("image/png")
w.write(plot, new FileOutputStream("test.png"), 600, 800)

