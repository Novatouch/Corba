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
    public void verifierCoordonneesBancaires(String pCompte, String pCode)
        throws LivreEnLigne.ExceptionMoneyTransferRefused;

}
