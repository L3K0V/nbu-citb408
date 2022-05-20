package hw6.t3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {

    @Test
    public void sample0() {
        final String text = "seamless.com (4.2) BURGER KING and Seamless - Your BK Favorites, Delivered About Seamless Get our Mobile App grubhub.com (4.4) Visit Website Burger King Delivery - New York AdOrder Delivery from Burger King on Grubhub. Gift Cards Available. Place An Order. Find Food. billsbarandburger.com (4.1) Best Burger NYC - Dine at Bill's Bar & Burger AdEnjoy hand-pressed, freshly ground burgers, fries, shakes and more. See menu. 16 W 51st St, New York, NY View Menu & Specials newyorkemcee.com (4.2) +1 518-424-5811 Tom Stebbins - THE BEST emcee for your event index.about.com (3.2) NY McDonalds - NY McDonalds Types: Business, Finance, Health. biocare-inc.com (4.1) +1 914-315-6868 Brain Health Coaching, NY pandcpediatric_dentistry.com (3.4) +1 973-928-3880 Quality NJ Pediatric Dentist - Voted NJ Family's Favorite 1011 Clifton Ave Suite 2H, Clifton, NJ mcdonalds.de (4.8) Rixbecker Strase 2, 59555 Lippstadt, Volkmar Dieter Jahnke Schnell-Restaurant, Tel.: +49 2941 58720, landcorpgroup.com (5) Land Corp Group - Hotel Remodeling Available, stuccoct.com (4) Stucco Contractor - Certified by Dryvit, Senergy luvurhome.com (-.-) +1 718-541-3011 Baybridge Condo Sheryl Fine - Luxury Bayside Condos - For Sale or Rent. Indoor Outdoor Pools. business.google.com (0.0) House Special - Chinatown local favorite Chinese grandparents love it here. Try THE House Chicken - so crispy!";

        assertEquals(5.0, Result.maxRating(text));
    }

    @Test
    public void sample1() {
        final String text = "seamless.com (4.2) BURGER KING and Seamless - Your BK Favorites, Delivered About Seamless Get our Mobile App grubhub.com (4.4) Visit Website Burger King Delivery - New York AdOrder Delivery from Burger King on Grubhub. Gift Cards Available. Place An Order. Find Food. billsbarandburger.com (4.1) Best Burger NYC - Dine at Bill's Bar & Burger AdEnjoy hand-pressed, freshly ground burgers, fries, shakes and more. See menu. 16 W 51st St, New York, NY View Menu & Specials newyorkemcee.com (4.2) +1 518-424-5811 Tom Stebbins - THE BEST emcee for your event index.about.com (3.2) NY McDonalds - NY McDonalds Types: Business, Finance, Health. biocare-inc.com (4.1) +1 914-315-6868 Brain Health Coaching, NY pandcpediatric_dentistry.com (3.4) +1 973-928-3880 Quality NJ Pediatric Dentist - Voted NJ Family's Favorite 1011 Clifton Ave Suite 2H, Clifton, NJ mcdonalds.de (4.8) Rixbecker Strase 2, 59555 Lippstadt, Volkmar Dieter Jahnke Schnell-Restaurant, Tel.: +49 2941 58720, landcorpgroup.com (4.5) Land Corp Group - Hotel Remodeling Available, stuccoct.com (4) Stucco Contractor - Certified by Dryvit, Senergy luvurhome.com (-.-) +1 718-541-3011 Baybridge Condo Sheryl Fine - Luxury Bayside Condos - For Sale or Rent. Indoor Outdoor Pools. business.google.com (0.0) House Special - Chinatown local favorite Chinese grandparents love it here. Try THE House Chicken - so crispy!";

        assertEquals(4.8, Result.maxRating(text));
    }
}
