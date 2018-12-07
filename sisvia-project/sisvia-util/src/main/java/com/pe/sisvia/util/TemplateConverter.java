package com.pe.sisvia.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import com.itextpdf.html2pdf.HtmlConverter;

import freemarker.cache.FileTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;

public class TemplateConverter {

	private static final String ENCODING = "UTF-8";

	public static void main(String[] args) {
		TemplateConverter t = new TemplateConverter();
		Map<String, Object> input = new HashMap<String, Object>();
		input.put("textoSubtitulo", "<span>Este textto</span><br /><span>Este textto</span>");
		input.put("montoAlimentacion", "S/. 100");
		input.put("filasAlimentacion", "  <tr>\r\n" + 
				"            <td>aa</td>\r\n" + 
				"            <td>aa</td>\r\n" + 
				"            <td>aa</td>\r\n" + 
				"            <td>aa</td>\r\n" + 
				"            <td>aa</td>\r\n" + 
				"        </tr>");
		input.put("montoAlojamiento", "S/. 100");
		input.put("filasAojamiento", "  <tr>\r\n" + 
				"            <td>aa</td>\r\n" + 
				"            <td>aa</td>\r\n" + 
				"            <td>aa</td>\r\n" + 
				"            <td>aa</td>\r\n" + 
				"            <td>aa</td>\r\n" + 
				"        </tr>");
		input.put("montoMovilidad", "S/. 100");
		input.put("filasMovilidad", "  <tr>\r\n" + 
				"            <td>aa</td>\r\n" + 
				"            <td>aa</td>\r\n" + 
				"            <td>aa</td>\r\n" + 
				"            <td>aa</td>\r\n" + 
				"            <td>aa</td>\r\n" + 
				"        </tr>");
		t.converterTemplateDocumentoPDF("C:/templates/", "rep_movimientos_pdf.tpl", input,
				"C:/templates/rep_movimientos.pdf");

	}

	public File converterTemplateDocumentoPDF(String basePathTemplate, String nameTemplate, Map<String, Object> input,
			String outputFile) {
		try {
			Configuration cfg = new Configuration();
			cfg.setDefaultEncoding(ENCODING);
			FileTemplateLoader loader;
			loader = new FileTemplateLoader(new File(basePathTemplate));
			cfg.setTemplateLoader(loader);
			StringWriter stringWriter = new StringWriter();
			Template template = cfg.getTemplate(nameTemplate);
			template.process(input, stringWriter);
			HtmlConverter.convertToPdf(stringWriter.toString(), new FileOutputStream(outputFile));
			return new File(outputFile);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

}
