import java.awt.BorderLayout as BL
import javax.swing.WindowConstants as WC
import groovy.swing.SwingBuilder
import javax.swing.ImageIcon

println "hello world and not a good morning"

String base = 'http://chart.apis.google.com/chart?'

def params = [cht:'p3',chs:'250x100',chd:'t:60,40',chl:'Hello|World']
//params.collect { k,v -> "$k=$v" }
//["cht=p3", "chs=250x100", "chd=t:60,40", "chl=Hello|World"].join('&')

String qs = params.collect { k,v -> "$k=$v" }.join('&')

params.each { k,v ->assert qs.contains("$k=$v") }

SwingBuilder.edt 
{
frame(title:'Hello, World!', visible:true, pack: true,
defaultCloseOperation:WC.EXIT_ON_CLOSE) {
label(icon:new ImageIcon("$base$qs".toURL()),
constraints:BL.CENTER)
}
}