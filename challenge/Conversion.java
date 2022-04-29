package isaac.challenge;
/**
 *
 * @author Isaac
 */
public class Conversion {
    public String conversion="";
    int base;
    int num;

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getConversion() {
        return conversion;
    }

    public void setConversion(String conversion) {
        this.conversion = conversion;
    }
    public void ConsConver(int b, int n){
        num=n; base=b;
    }
    public String Convertir(){
        int residuo;
        if(base==16){
           String[] caracteresHexadecimales = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};
           while (num > 0) {
               residuo = num % 16;
               String caracterHexadecimal = caracteresHexadecimales[residuo];
               conversion = caracterHexadecimal + conversion;
               num = num / 16;
           }
        }
        else{
            while(num > 0){
                conversion = num%base + conversion;
                num = num/base;
            }
        }
        return conversion;
    }

}
