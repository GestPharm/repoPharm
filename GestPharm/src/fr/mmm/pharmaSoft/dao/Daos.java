package fr.mmm.pharmaSoft.dao;

public class Daos {
	
	private CommandeDao commandeDao;
	
	
	
	private EmployeDao employeDao;
	
	private StockDao stockDao;
	
	private MedicamentDao medicamentDao;

	public Daos() {
		super();
		medicamentDao=new MedicamentDao();
		commandeDao = new CommandeDao();
		
		
	}

	public CommandeDao getCommandeDao() {
		return commandeDao;
	}

	public void setCommandeDao(CommandeDao commandeDao) {
		this.commandeDao = commandeDao;
	}

	

	public EmployeDao getEmployeDao() {
		return employeDao;
	}

	public void setEmployeDao(EmployeDao employeDao) {
		this.employeDao = employeDao;
	}

	public StockDao getStockDao() {
		return stockDao;
	}

	public void setStockDao(StockDao stockDao) {
		this.stockDao = stockDao;
	}

	public MedicamentDao getMedicamentDao() {
		return medicamentDao;
	}

	public void setMedicamentDao(MedicamentDao medicamentDao) {
		this.medicamentDao = medicamentDao;
	}
	
	
	
	
	
	

}
