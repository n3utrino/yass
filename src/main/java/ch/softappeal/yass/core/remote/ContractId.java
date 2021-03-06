package ch.softappeal.yass.core.remote;

import ch.softappeal.yass.util.Check;

/**
 * Combines a contract with an id.
 * @param <C> the contract type
 */
public final class ContractId<C> {

    public final Class<C> contract;
    public final int id;

    private ContractId(final Class<C> contract, final int id) {
        this.contract = Check.notNull(contract);
        this.id = id;
    }

    public static <C> ContractId<C> create(final Class<C> contract, final int id) {
        return new ContractId<>(contract, id);
    }

}
