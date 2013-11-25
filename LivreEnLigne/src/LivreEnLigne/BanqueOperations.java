package LivreEnLigne;

/**
 * Interface definition : Banque
 * 
 * @author OpenORB Compiler
 */
public interface BanqueOperations
{
    /**
     * Operation verifierCoordonneesBancaires
     */
    public void verifierCoordonneesBancaires(int pCompte, int pCode)
        throws LivreEnLigne.MoneyTransferRefused;

}
