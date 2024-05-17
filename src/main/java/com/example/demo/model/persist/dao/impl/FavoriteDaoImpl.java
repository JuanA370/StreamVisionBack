package com.example.demo.model.persist.dao.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.entities.Favorite;
import com.example.demo.model.entities.Product;
import com.example.demo.model.entities.UserEntity;
import com.example.demo.model.persist.dao.FavouriteDao;
import com.example.demo.model.persist.repository.FavoriteRepository;

@Service
public class FavoriteDaoImpl implements FavouriteDao{
	
	private FavoriteRepository favoriteRep;
	@Override
	public Favorite saveFav(Favorite favourite) {
		Favorite fav = favoriteRep.findFavById(favourite.getFavoritePk().getProductId(), favourite.getFavoritePk().getUserId());
		return fav;
	}

	@Override
	public List<Product> listFav(UserEntity usuario) {
		List<Product> list= favoriteRep.findFavProductByUser(usuario.getId());
		return list;
	}
	
}
