import javax.swing.ImageIcon;

public class NaveEnemiga extends Nave {

	private JLabelNave imgDir;
	
	public NaveEnemiga(double posX, double posY) {
		super(posX, posY);
		imgDir = new JLabelNave (System.getProperty("user.dir")+"\\img\\enemigo.png");
		System.out.println(imgDir);
		// TODO Auto-generated constructor stub
	}

	public JLabelNave getImgDir() {
		return imgDir;
	}

	public void setImgDir(JLabelNave imgDir) {
		this.imgDir = imgDir;
	}
	
	@Override
	public void setPosX(double posX) {
		super.setPosX(posX);
		this.imgDir.setPosX(posX);
	}
	
	@Override
	public void setPosY(double posY) {
		super.setPosY(posY);
		this.imgDir.setPosY(posY);
	}

}
