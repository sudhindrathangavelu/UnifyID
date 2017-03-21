package Servlets;

import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RandomImage
 */
public class RandomImage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor. 
	 */
	public RandomImage() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		String[] darray=request.getParameterValues("random[]");
		/*for(int i=0;i<darray.length;i++){
			System.out.println(darray[i]);
		}*/
		int randomlength=darray.length;
		int width=128;
		int height=128;
		BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		File f = null;
		//create random image pixel by pixel
		int count=0;
		int r,g,b,p;
		for(int y = 0; y < height; y++){
			for(int x = 0; x < width; x++){

				if(count<randomlength){
					r = Integer.valueOf(darray[count])*256; //red
					count++;
				}
				else{
					count=0;
					r = Integer.valueOf(darray[count])*256; //red
					count++;
				}
				if(count<randomlength){
					g = Integer.valueOf(darray[count])*256; //green
					count++;
				}
				else{
					count=0;
					g = Integer.valueOf(darray[count])*256; //green
					count++;
				}

				if(count<randomlength){
					b = Integer.valueOf(darray[count])*256; //blue
					count++;
				}
				else{
					count=0;
					b = Integer.valueOf(darray[count])*256; //blue
					count++;
				}
				
				p = (r<<16) | (g<<8) | (b); //pixel

				img.setRGB(x, y, p);
			}
		}
		try{


			String path="C:\\Users\\sudhindra\\UnifyID\\RGBImage\\WebContent\\Images\\Output.png";
			System.out.println("Path:"+path);
			//System.out.println("Path:"+fullPathToYourWebappRoot);
			f = new File(path);
			ImageIO.write(img, "png", f);
		}catch(IOException e){
			System.out.println("Error: " + e);
		}
		out.println("Images\\Output.png");
	}

}
