package ParserPackage;

import java.util.ArrayList;

import com.sun.xml.internal.ws.api.streaming.XMLStreamReaderFactory.Default;

public class SymbolTable {
	
	private  ArrayList<SymbolT> Symbols = new ArrayList();
	
	public void add(Token name, Token typeName){
		SymbolT newSy = new SymbolT(name.toString(), typeName.toString());
		
		if(!check(newSy)) { 
			Symbols.add(newSy);
		}
	}
	
	public void printList(){
		System.out.println("In Printlist");
		for(int i = 0; i< Symbols.size() ; i++){
			System.out.println(Symbols.get(i).name + " " + Symbols.get(i).type +" "+ i);
		}
	}
	
	private boolean check(SymbolT newSy ){
		for(int i = 0; i< Symbols.size(); i++){
			if(Symbols.get(i).name.equals(newSy.name)){	
				return  true;
			}
		}
		return false;
	}
	
	public enum VarType {
		INT, VOID, BOOLEAN, FUNCTION, PROGRAM, NON
	}
	
	public class SymbolT {
		public String name;
		public VarType type;
		
		public SymbolT(String Name, String typeName){
			
			this.name = Name;
			this.type = mapType(typeName);
		}
	}
	
	private VarType mapType(String typeName){
		switch(typeName){
		case "void":
			return VarType.VOID;
		case "int":
			return VarType.INT;
		case "boolean":
			return VarType.BOOLEAN;	
		case "function":
			return VarType.FUNCTION;
		case "program":
			return VarType.PROGRAM;
		default: return VarType.NON;
		}
	}
	
}

