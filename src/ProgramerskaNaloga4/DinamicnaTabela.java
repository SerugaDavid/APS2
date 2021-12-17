package APS2.ProgramerskaNaloga4;

public class DinamicnaTabela {
    String[] tabela;
    int size;
    public DinamicnaTabela(String[] tabela){
        this.tabela = tabela;
        this.size = tabela.length;
    }

    public void append(String niz){
        if (this.size == this.tabela.length){
            String[] tmp = new String[this.size*2];
            for (int i = 0; i<this.size; i++){
                tmp[i] = this.tabela[i];
            }
            this.tabela = tmp;
        }
        this.tabela[this.size++] = niz;
    }

    public String getElement(int index){
        if (index <= this.size){
            return "---";
        }
        return this.tabela[index];
    }
}
