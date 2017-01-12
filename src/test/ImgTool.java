package test;

import java.util.*;

import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class ImgTool {
	
	public ImgTool() {
		
	}

	public void binarization(String oriImg, String outputImg) {       
        Mat img = Imgcodecs.imread(oriImg);
        Imgproc.cvtColor(img, img, Imgproc.COLOR_RGB2GRAY); 
        Imgproc.adaptiveThreshold(img, img, 255, Imgproc.ADAPTIVE_THRESH_MEAN_C, Imgproc.THRESH_BINARY_INV, 25, 10);
        Imgcodecs.imwrite(outputImg, img);
    }
	
	public void graying(String oriImg, String outputImg) {       
        Mat img = Imgcodecs.imread(oriImg);
        Imgproc.cvtColor(img, img, Imgproc.COLOR_RGB2GRAY);      
        Imgcodecs.imwrite(outputImg, img);
    }
	
	public void txtCleanWaterMarkByHist(String oriImg, String outputImg){
		Mat img = Imgcodecs.imread(oriImg);
		Imgproc.cvtColor(img, img, Imgproc.COLOR_RGB2GRAY); //�ҶȻ�
		//ֱ��ͳ��
		List<Mat> imgList = new ArrayList<Mat>();	//���ü��������ֱ��ͳ��
		imgList.add(img);
		MatOfInt histSize = new MatOfInt(256);
		MatOfFloat histRange = new MatOfFloat(0, 256);
		MatOfInt channels = new MatOfInt(0);
		Mat hist = new Mat();
		Imgproc.calcHist(imgList.subList(0, 1), channels, new Mat(), hist , histSize, histRange, false);
		//�ҳ���Ƶ���ɫ����Ϊ��ֵ
		int maxLimit = 50;
		int threshold = maxLimit;
		int maxNum = 0;		//ֱ��ͳ����0-maxLimit��ߵ�
		int thresMargin = 10;
		for(int i=0;i<maxLimit;i++){
			if(hist.get(i, 0)[0] > maxNum){
				maxNum = (int)(hist.get(i, 0)[0]);
				threshold = i;
			}
		}
		threshold +=thresMargin;
		//��ֵ��
		Imgproc.threshold(img, img, threshold, 255, Imgproc.THRESH_BINARY);
		Imgcodecs.imwrite(outputImg, img);
	}
	
	public void txtCleanWaterMarkByOtsu(String oriImg, String outputImg){
		Mat img = Imgcodecs.imread(oriImg);
		Imgproc.cvtColor(img, img, Imgproc.COLOR_RGB2GRAY); //�ҶȻ�
		Imgproc.threshold(img, img, 0, 255, Imgproc.THRESH_OTSU);
		Imgcodecs.imwrite(outputImg, img);
	}
}
