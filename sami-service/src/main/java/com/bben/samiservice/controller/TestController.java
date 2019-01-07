package com.bben.samiservice.controller;

import com.bben.samiservice.converter.HL7ToXmlConverter;
import org.dom4j.Document;
import org.dom4j.Node;

import java.util.List;

public class TestController {
    public static void main(String[] args) {
        /*String myHL7string="MSH|^~\\&|HIS||bedside2||20181225101446||MFN^M01|55924674|P|2.4|||AL|AL|CHN\n" +
                "MFI|Employee^人员^HIS||UPD|20181225101502|20181225101502|AL\n" +
                "MFE|MUP|||00111|CE\n" +
                "Z02|00111|李秋明|F|19640921000000|7|25|01|430404196809210041|9103^护理中心||N|0|1|0|LQM|STJ|000000|20181225101502\n";*/
       /* String myHL7string="MSH|^~\\&|HIS||bedside2||20181225100530||MFN^M01|55924672|P|2.4|||AL|AL|CHN\n" +
                "MFI|Department^科室^HIS||UPD|20181225100546|20181225100546|AL\n" +
                "MFE|MUP|||6090|CE\n" +
                "Z01|6090|手术室药房||手术室药房|P|0|0|1|1|0|SSSYF|RSPAY|000000|20181225100546";*/

       /* String myHL7string = "MSH|^~\\&|HIS||EAI||20181225100442||MFN^M01|55924671|P|2.4|||AL|AL|CHN\n" +
                "MFI|Department^科室^HIS||UPD|20181225100458|20181225100458|AL\n" +
                "MFE|MAD|||6090|CE\n" +
                "Z01|6090|手术室药房||手术室药房|P|0|0|1|1|0|SSSYF|RSPAY|000000|20181225100458";*/
        String myHL7string = "MSH|^~\\&|HIS||bedside2||20181213161523||MFN^M01|55882632|P|2.4|||AL|AL|CHN\n" +
                "MFI|Department^科室^HIS||UPD|20181213161609|20181213161609|AL\n" +
                "MFE|MUP|||7117|CE\n" +
                "Z01|7117|口腔科分诊台||口腔科分诊台|N|0|0|0|0|0|KQKFZT|KETWYC|000000|20181213161609";
        Document document = HL7ToXmlConverter.ConvertToXmlObject(myHL7string);
//获取事件
        String eventName = HL7ToXmlConverter.GetText(document, "MSH/MSH.9");
        System.out.println("eventName:"+eventName);
// List nodeValue = document.selectNodes("MSH.1");
        String nodeValue = document.selectSingleNode("HL7Message/MSH").getText();
        String nodeValues = document.selectSingleNode("HL7Message/MSH/MSH.9/MSH.9.1").getText();
        String nodeValue2 = document.selectSingleNode("HL7Message/MSH/MSH.9/MSH.9.2").getText();
        String nodeValue3 = document.selectSingleNode("HL7Message/MSH/MSH.5").getText();
        String val = document.selectSingleNode("HL7Message/Z01").getName();
        String val1 = document.selectSingleNode("HL7Message/Z01").getText();
        String val2 = document.selectSingleNode("HL7Message/Z01/Z01.1").getText();
        //String val3 = document.selectSingleNode("HL7Message/Z02").getName();
        String S1 = document.selectSingleNode("HL7Message/MFI/MFI.1/MFI.1.1").getText();
        String value1 = HL7ToXmlConverter.GetText(document, "MFI/MFI.1/MFI.1.1");
        String value = HL7ToXmlConverter.GetText(document, "MFI/MFI.1/MFI.1.1",0);

        String value2 = HL7ToXmlConverter.GetText(document, "Z01/Z01.1");
        // DocumentElement.SelectNodes(path);
        System.out.println(nodeValue+":"+nodeValue2);
        System.out.println(nodeValue+":"+nodeValue3);
/*        String value = HL7ToXmlConverter.GetText(document, "QRD/QRD.9/QRD.9.1",0);
        String value1 = HL7ToXmlConverter.GetText(document, "QRD/QRD.9/QRD.9.2",1);
        String value2 = HL7ToXmlConverter.GetText(document, "QRD/QRD.9/QRD.9.3");*/
        String s = HL7ToXmlConverter.GetText(document, "Z02",0);



        String value3 = HL7ToXmlConverter.GetText(document, "Z02/Z02.1");
        String value4 = HL7ToXmlConverter.GetText(document, "Z02/Z02.2",0);
        List<Node> list = HL7ToXmlConverter.GetTexts(document, "QRD/QRD.9/QRD.9.1");
        for(Node node : list)
        {
            System.out.println(":"+node.getText());
        }
        System.out.println(HL7ToXmlConverter.ConvertToXml(myHL7string));
    }
}
