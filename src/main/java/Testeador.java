import fr.w3blog.zpl.constant.ZebraFont;
import fr.w3blog.zpl.model.ZebraLabel;
import fr.w3blog.zpl.model.ZebraPrintException;
import fr.w3blog.zpl.model.ZebraUtils;
import fr.w3blog.zpl.model.element.ZebraBarCode39;
import fr.w3blog.zpl.model.element.ZebraText;

public class Testeador {


    public static void main(String [ ] args) {
        ZebraLabel zebraLabel = new ZebraLabel(400, 300);
        zebraLabel.setDefaultZebraFont(ZebraFont.ZEBRA_ZERO);
        int positionY=20;
        int incremento=20;
        int fontSize=2;
        int positionX=60;


        zebraLabel.addElement(new ZebraText(positionX, positionY, "RUTA {index}:", fontSize));
        positionY=positionY+incremento;
        zebraLabel.addElement(new ZebraText(positionX, positionY, "UNIDAD: URAPANES {index}", fontSize));

        positionY=positionY+incremento;
        zebraLabel.addElement(new ZebraText(positionX, positionY, "BLOQUE: E ", fontSize));


        positionY=positionY+incremento;
        zebraLabel.addElement(new ZebraText(positionX, positionY, "'BOLSA :     1 ", fontSize));


        positionY=positionY+incremento;
        zebraLabel.addElement(new ZebraText(positionX, positionY, "2011-NOV-12", fontSize));



        positionY=positionY+incremento;
        zebraLabel.addElement(new ZebraText(positionX, positionY, "APARTAMENTO {APARTAMENTO}", fontSize));

        //Add Code Bar 39
        positionY=200;
        System.out.print(positionY);
        zebraLabel.addElement(new ZebraBarCode39(positionX, positionY, "146238082{index}", 60, 1, 2));

        System.out.print(zebraLabel.getZplCode());

        String ip = "127.0.0.1";
        int port = 9100;
        try {
            ZebraUtils.printZpl(zebraLabel, ip, port);
        } catch (ZebraPrintException e) {
            e.printStackTrace();
        }


    }
}