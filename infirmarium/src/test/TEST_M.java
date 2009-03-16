package test;

import com.hospital.hr.Department;
import com.hospital.hr.HealthWorker;
import com.hospital.manageres.DaoManager;
import com.hospital.modulecreator.Field;
import com.hospital.modulecreator.FieldTypes;
import com.hospital.modulecreator.Module;
import com.hospital.modulecreator.Record;

public class TEST_M {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		Card c = new Card();

		
		
		Module m1 =new Module();
		m1.setModuleName("skargu");
		Record r = new Record();
		Field f = new Field();
		f.setType(FieldTypes.TEXTBOX);
		r.setField(f);
		m1.setParameter("bil", r);
		
		
		HealthWorker hw = new HealthWorker();
		hw.setFirstName("Artur");
		hw.setLastName("Konan");
		
		Department d = new Department();
		d.setName("travmatologiya");
		
		d.addModule(m1);
		d.addHealthWorker(hw);

		
		new DaoManager<Department>().newInstance(d);
		
		
		
		
		
		
	}

}
