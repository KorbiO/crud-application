package com.example.demo.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.Article;
import com.example.demo.entity.Client;
import com.example.demo.entity.Commande;
import com.example.demo.entity.Facture;
import com.example.demo.entity.ImageModel;
import com.example.demo.repository.ArticleRepository;
import com.example.demo.repository.ClientRepository;
import com.example.demo.repository.CommandeRepository;
import com.example.demo.repository.FactrureRepository;
import com.example.demo.repository.ImageRepository;
import com.example.demo.repository.VenteFlashRepository;

@RestController
@CrossOrigin("*")
public class ImageController {
	@Autowired
	private FactrureRepository factureRepo;
	@Autowired
	private VenteFlashRepository venteFlashRepo;
	@Autowired
	private ArticleRepository articleRepo ;
	@Autowired
	private ImageRepository imageRepository;
	@Autowired
	private ClientRepository client ;
	
	@Autowired
	private CommandeRepository commandeRepo;
	@GetMapping("/findClient/{id}")
	public Optional<Client> findClient(@PathVariable("id") String id){
		return client.findById(id);
		
	}
	@DeleteMapping("/deleteAll")
	public void deleteAllVF() {
		venteFlashRepo.deleteAll();
	}
	@PostMapping("/image") //BodyBuilder
	public ImageModel uplaodImage(@RequestParam("imageFile") MultipartFile file) throws IOException {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Access-Control-Allow-Origin", "*");
		headers.add("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
		headers.add("Access-Control-Allow-Headers", "Origin, Accept, X-Requested-With, Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers,authorization");
		headers.add("Access-Control-Allow-Credentials", "true");
		headers.add("Access-Control-Expose-Headers", "Access-Control-Allow-Origin, Access-Control-Allow-Credentials, authorization");
		System.out.println("Original Image Byte Size - " + file.getBytes().length);
		ImageModel img = new ImageModel(file.getOriginalFilename(), file.getContentType(),
				compressBytes(file.getBytes()));
		imageRepository.save(img);
		return img;
	}	

	@GetMapping(path = { "/get/{imageName}" })
    public ImageModel getImage(@PathVariable("imageName") String imageName) throws IOException {
		
		final Optional<ImageModel> retrievedImage = imageRepository.findByName(imageName);
        System.out.println(retrievedImage.get().getName());
        ImageModel img = new ImageModel(retrievedImage.get().getName(), retrievedImage.get().getType(),
                decompressBytes(retrievedImage.get().getPicByte()));
        return img;
    }
	public static byte[] compressBytes(byte[] data) {
		Deflater deflater = new Deflater();
		deflater.setInput(data);
		deflater.finish();

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] buffer = new byte[1024];
		while (!deflater.finished()) {
			int count = deflater.deflate(buffer);
			outputStream.write(buffer, 0, count);
		}
		try {
			outputStream.close();
		} catch (IOException e) {
		}
		System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);

		return outputStream.toByteArray();
	}

	
	public static byte[] decompressBytes(byte[] data) {
		Inflater inflater = new Inflater();
		inflater.setInput(data);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] buffer = new byte[1024];
		try {
			while (!inflater.finished()) {
				int count = inflater.inflate(buffer);
				outputStream.write(buffer, 0, count);
			}
			outputStream.close();
		} catch (IOException ioe) {
		} catch (DataFormatException e) {
		}
		return outputStream.toByteArray();
	}
	@GetMapping("/charts")
	public List<Integer> chartsPriceArticle(){
		List<Article> l = articleRepo.findAll();
		int nbArt = 0;
		int nbArt2 = 0;
		int nbArt3 = 0;
		List<Integer> lo= new ArrayList<>();
		
		for (Article a : l ) {
			if (a.getPrixArt() >10 && a.getPrixArt() < 1000 ){
				nbArt = nbArt + 1 ;
				
			}else if (a.getPrixArt() >1001 && a.getPrixArt() < 2000  ) {
				nbArt2 = nbArt2 + 1 ;
				
			}else if (a.getPrixArt() >2001 && a.getPrixArt() < 3000) {
				nbArt3 = nbArt3 + 1 ;
				
			}
		}
		if ( nbArt != 0 ) {
			lo.add(nbArt);
		}else {
			lo.add(0);
		}
		if ( nbArt2 != 0 ) {
			lo.add(nbArt2);
		}else {
			lo.add(0);
		}
		if ( nbArt3 != 0 ) {
			lo.add(nbArt3);
		}else {
			lo.add(0);
		}
		
		return lo ;
		
	}
	@GetMapping("/countCommande")
	public List<Integer> chartsNbrCommande(){
		List<Commande> listCmd = commandeRepo.findAll(); 
		List<Integer> nbrCmd = new ArrayList<>();
		int nbr12 = 0, nbr34 = 0,nbr56 = 0,nbr78 = 0,nbr910 = 0,nbr1112 = 0 ;
		for (Commande c : listCmd) {
			if(c.getDateCmd().getMonthValue()>=0 && c.getDateCmd().getMonthValue()<=2) {
				nbr12 = nbr12 +1 ;
				
			}
			if (c.getDateCmd().getMonthValue()>=2 && c.getDateCmd().getMonthValue()<=4) {
				nbr34 = nbr34 + 1 ;
				
			}
			if (c.getDateCmd().getMonthValue()>=4 && c.getDateCmd().getMonthValue()<=6) {
				nbr56=nbr56 +1;
				
			}
			if (c.getDateCmd().getMonthValue()>=6 && c.getDateCmd().getMonthValue()<=8) {
				nbr78=nbr78 +1;
				
			}
			if (c.getDateCmd().getMonthValue()>=8 && c.getDateCmd().getMonthValue()<=10) {
				nbr910=nbr910 +1;
				
			}
			if (c.getDateCmd().getMonthValue()>=10 ) {
				nbr1112 = nbr1112 +1;
				
			}
			
			
		}
		if(nbr12 != 0) {
			nbrCmd.add(nbr12);
		}else {
			nbrCmd.add(0);
		}
		if(nbr34 != 0) {
			nbrCmd.add(nbr34);
		}else {
			nbrCmd.add(0);
		}
		if(nbr56 != 0) {
			nbrCmd.add(nbr56);
		}else {
			nbrCmd.add(0);
		}
		if(nbr78 != 0) {
			nbrCmd.add(nbr78);
		}else {
			nbrCmd.add(0);
		}
		if(nbr910 != 0) {
			nbrCmd.add(nbr910);
		}else {
			nbrCmd.add(0);
		}
		if(nbr1112 != 0) {
			nbrCmd.add(nbr1112);
		}else {
			nbrCmd.add(0);
		}
		return nbrCmd ;
	}
	
	@GetMapping("/chiffreAffaire")
	public List<Double> CalculeChiffreaf() {
		double chAff12 = 0 ;
		double chAff34 = 0 ;
		double chAff56 = 0 ;
		double chAff78 = 0 ;
		double chAff910 = 0 ;
		double chAff1112 = 0 ;
		List<Double> chAff = new ArrayList<>();
		List<Facture> fa = factureRepo.findAll();
		for (Facture f : fa) {
			if(f.getDateFact().getMonthValue()>=0 && f.getDateFact().getMonthValue()<=2) {
				chAff12 = f.getTotalTtc() + chAff12 ; 
				
			}
			if (f.getDateFact().getMonthValue()>=2 && f.getDateFact().getMonthValue()<=4) {
				chAff34 = f.getTotalTtc() + chAff34 ; 
				
			}
			if (f.getDateFact().getMonthValue()>=4 && f.getDateFact().getMonthValue()<=6) {
				chAff56 = f.getTotalTtc() + chAff56 ; 
				
			}
			if (f.getDateFact().getMonthValue()>=6 && f.getDateFact().getMonthValue()<=8) {
				chAff78 = f.getTotalTtc() + chAff78 ; 
				
			}
			if (f.getDateFact().getMonthValue()>=8 && f.getDateFact().getMonthValue()<=10) {
				chAff910 = f.getTotalTtc() + chAff910 ; 
				
			}
			if (f.getDateFact().getMonthValue()>=10 ) {
				chAff1112 = f.getTotalTtc() + chAff1112 ; 
				
			}
		}
		if(chAff12 != 0.0 ) {
			chAff.add(chAff12);
		}else {
			chAff.add(0.0);
		}
		if(chAff34 != 0.0 ) {
			chAff.add(chAff34);
		}else {
			chAff.add(0.0);
		}
		if(chAff56 != 0.0 ) {
			chAff.add(chAff56);
		}else {
			chAff.add(0.0);
		}
		if(chAff78 != 0.0 ) {
			chAff.add(chAff78);
		}else {
			chAff.add(0.0);
		}
		if(chAff910 != 0.0 ) {
			chAff.add(chAff910);
		}else {
			chAff.add(0.0);
		}
		if(chAff1112 != 0.0 ) {
			chAff.add(chAff1112);
		}else {
			chAff.add(0.0);
		}
		return chAff ;
	}
	
}
