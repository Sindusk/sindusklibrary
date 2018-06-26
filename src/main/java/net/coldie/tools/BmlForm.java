package net.coldie.tools;

import java.util.logging.Level;
import java.util.logging.Logger;

public class BmlForm {
    private static Logger logger = Logger.getLogger(BmlForm.class.getName());
    private final StringBuffer buf = new StringBuffer();
    private int openBorders = 0;
    private int openCenters = 0;
    private int openVarrays = 0;
    private int openScrolls = 0;
    private int openHarrays = 0;
    private int openTrees = 0;
    private int openRows = 0;
    private int openColumns = 0;
    private int openTables = 0;
    private int indentNum = 0;
    private boolean beautify = false;
    private boolean closeDefault = false;

    public BmlForm() {
    }

    public BmlForm(String formTitle) {
        this.addDefaultHeader(formTitle);
    }

    public void addDefaultHeader(String formTitle) {
        if (this.closeDefault) {
            return;
        }
        this.beginBorder();
        this.beginCenter();
        this.addBoldText(formTitle, new String[0]);
        this.endCenter();
        this.beginScroll();
        this.beginVerticalFlow();
        this.closeDefault = true;
    }

    public void beginBorder() {
        this.buf.append(this.indent("border{"));
        ++this.indentNum;
        ++this.openBorders;
    }

    public void endBorder() {
        --this.indentNum;
        this.buf.append(this.indent("}"));
        --this.openBorders;
    }

    public void beginCenter() {
        this.buf.append(this.indent("center{"));
        ++this.indentNum;
        ++this.openCenters;
    }

    public void endCenter() {
        --this.indentNum;
        this.buf.append(this.indent("};null;"));
        --this.openCenters;
    }

    public void beginVerticalFlow() {
        this.buf.append(this.indent("varray{rescale=\"true\";"));
        ++this.indentNum;
        ++this.openVarrays;
    }

    public void endVerticalFlow() {
        --this.indentNum;
        this.buf.append(this.indent("}"));
        --this.openVarrays;
    }

    public void beginScroll() {
        this.buf.append(this.indent("scroll{vertical=\"true\";horizontal=\"false\";"));
        ++this.indentNum;
        ++this.openScrolls;
    }

    public void endScroll() {
        --this.indentNum;
        this.buf.append(this.indent("};null;null;"));
        --this.openScrolls;
    }

    public void beginHorizontalFlow() {
        this.buf.append(this.indent("harray {"));
        ++this.indentNum;
        ++this.openHarrays;
    }

    public void endHorizontalFlow() {
        --this.indentNum;
        this.buf.append(this.indent("}"));
        --this.openHarrays;
    }

    public void beginTable(int rowCount, String[] columns) {
        this.buf.append(this.indent("table {rows=\"" + rowCount + "\"; cols=\"" + columns.length + "\";"));
        ++this.indentNum;
        String[] arrstring = columns;
        int n = arrstring.length;
        int n2 = 0;
        while (n2 < n) {
            String c = arrstring[n2];
            this.addLabel(c);
            ++n2;
        }
        --this.indentNum;
        ++this.indentNum;
        ++this.openTables;
    }

    public void endTable() {
        --this.indentNum;
        this.buf.append(this.indent("}"));
        --this.openTables;
    }

    public void addHidden(String name, String val) {
        this.buf.append(this.indent("passthrough{id=\"" + name + "\";text=\"" + val + "\"}"));
    }

    private String indent(String s) {
        return this.beautify ? String.valueOf(this.getIndentation()) + s + "\r\n" : s;
    }

    private String getIndentation() {
        if (this.indentNum > 0) {
            return "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t".substring(0, this.indentNum);
        }
        return "";
    }

    public void addRaw(String s) {
        this.buf.append(s);
    }

    public void addImage(String url, int height, int width) {
        this.addImage(url, height, width, "");
    }

    public void addImage(String url, int height, int width, String tooltip) {
        this.buf.append("image{src=\"");
        this.buf.append(url);
        this.buf.append("\";size=\"");
        this.buf.append(String.valueOf(height) + "," + width);
        this.buf.append("\";text=\"" + tooltip + "\"}");
    }

    public void addLabel(String text) {
        this.buf.append("label{text='" + text + "'};");
    }

    public void addInput(String id, int maxChars, String defaultText) {
        this.buf.append("input{id='" + id + "';maxchars='" + maxChars + "';text=\"" + defaultText + "\"};");
    }

    public void addColoredText(String text, int r, int g, int b, String ... args){
        this.addText(text, "", r, g, b, args);
    }

    public void addBoldText(String text, String ... args) {
        this.addText(text, "bold", args);
    }

    public void addBoldColoredText(String text, int r, int g, int b, String ... args){
        this.addText(text, "bold", r, g, b, args);
    }

    public void addText(String text, String ... args) {
        this.addText(text, "", args);
    }

    private void addText(String text, String type, String ... args){
        this.addText(text, type, -10, -10, -10, args);
    }
    private void addText(String text, String type, int r, int g, int b, String ... args) {
        String[] lines;
        String[] arrstring = lines = text.split("\n");
        int n = arrstring.length;
        int n2 = 0;
        while (n2 < n) {
            String l = arrstring[n2];
            if (this.beautify) {
                this.buf.append(this.getIndentation());
            }
            this.buf.append("text{");
            if (!type.equals("")) {
                this.buf.append("type='").append(type).append("';");
            }
            if(r >= 0 && g >= 0 && b >= 0 && r <= 255 && g <= 255 && b <= 255){
                this.buf.append("color='").append(r).append(",").append(g).append(",").append(b).append("';");
            }
            this.buf.append("text=\"");
            this.buf.append(String.format(l, args));
            this.buf.append("\"}");
            if (this.beautify) {
                this.buf.append("\r\n");
            }
            ++n2;
        }
    }

    public void addButton(String name, String id) {
        this.buf.append(this.indent("button{text='  " + name + "  ';id='" + id + "'}"));
    }

    public String toString() {
        if (this.closeDefault) {
            this.endVerticalFlow();
            this.endScroll();
            this.endBorder();
            this.closeDefault = false;
        }
        if (this.openCenters != 0 || this.openVarrays != 0 || this.openScrolls != 0 || this.openHarrays != 0 || this.openBorders != 0 || this.openTrees != 0 || this.openRows != 0 || this.openColumns != 0 || this.openTables != 0) {
            logger.log(Level.SEVERE, "While finalizing BML unclosed (or too many closed) blocks were found (this will likely mean the BML will not work!): center: " + this.openCenters + " vert-flows: " + this.openVarrays + " scroll: " + this.openScrolls + " horiz-flows: " + this.openHarrays + " border: " + this.openBorders + " trees: " + this.openTrees + " rows: " + this.openRows + " columns: " + this.openColumns + " tables: " + this.openTables);
        }
        return this.buf.toString();
    }
}
