package test;

import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class ImgTool {
	
	public ImgTool() {
		
	}

	public void binarization(String oriImg, String outputImg) {       
        Mat img = Imgcodecs.imread(oriImg);
        Imgproc.cvtColor(img, img, Imgproc.COLOR_RGB2GRAY);
        //
        Imgproc.adaptiveThreshold(img, img, 255, Imgproc.ADAPTIVE_THRESH_MEAN_C, Imgproc.THRESH_BINARY_INV, 25, 10);
        Imgcodecs.imwrite(outputImg, img);
    }
	
	public void graying(String oriImg, String outputImg) {       
        Mat img = Imgcodecs.imread(oriImg);
        Imgproc.cvtColor(img, img, Imgproc.COLOR_RGB2GRAY);      
        Imgcodecs.imwrite(outputImg, img);
    }
}
